package com.bank.pnc.account.pncbank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.bank.pnc.account.pncbank.dto.AccountFilterRequest;
import com.bank.pnc.account.pncbank.dto.AccountRequest;
import com.bank.pnc.account.pncbank.service.AccountBalanceService;
import com.bank.pnc.account.pncbank.util.PncBankUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author suresh R
 * @CreateDate 2021-01-21
 * @Description: Dealing account operations such as create, read, update
 */

@RestController
public class AccountBalanceController {
	
	@Autowired
	private AccountBalanceService accountBalanceService;
	
	@PostMapping("/accountCreate")
	public Object createAccount(@Valid @RequestBody AccountRequest accountRequest, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return PncBankUtil.getErrorList(bindResult);
		}
		
		return accountBalanceService.saveAccount(accountRequest);
	}
	
	@PostMapping("/getBalance")
	@ApiOperation(value = "Provides current balance of provided Account", response = Double.class)
	public Object getBalance(@Valid @RequestBody AccountFilterRequest accountFilterRequest, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return PncBankUtil.getErrorList(bindResult);
		}
		
		return accountBalanceService.getAccountBalance(accountFilterRequest);
	}
	
	@GetMapping("/getAccountList")
	public List<Integer> getAccountList(){
		return accountBalanceService.getAccountList();
	}
}
