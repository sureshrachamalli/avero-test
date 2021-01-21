package com.bank.pnc.account.pncbank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bank.pnc.account.pncbank.dto.AccountFilterRequest;
import com.bank.pnc.account.pncbank.dto.AccountTransactionsRequest;
import com.bank.pnc.account.pncbank.service.AccountTransactionService;
import com.bank.pnc.account.pncbank.util.PncBankUtil;

import io.swagger.annotations.ApiOperation;

/**
 * 
 * @author suresh R
 * @CreateDate 2021-01-21
 * @Description: Dealing account transactions operations such as create, read
 */

@RestController
public class AccountTransactionController {
	
	@Autowired
	private AccountTransactionService accountTransactionService;
	
	@PostMapping("/createTransaction")
	public Object postTransaction(@Valid @RequestBody AccountTransactionsRequest accountTransactionRequest, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return PncBankUtil.getErrorList(bindResult);
		}
		
		return accountTransactionService.createAccountTransaction(accountTransactionRequest);
	}
	
	@PostMapping("/getTransactionList/byType")
	@ApiOperation(value = "Provides List of Transactions for AccountNumber and TransactionType")
	public Object getTransactionsByType(@Valid @RequestBody AccountFilterRequest accountFilterRequest, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return PncBankUtil.getErrorList(bindResult);
		}
		
		return accountTransactionService.getAccountTransactionsByType(accountFilterRequest);
	}	
	
	@PostMapping("/getTransactionList/byDate")
	public Object getTransactionsByDate(@Valid @RequestBody AccountFilterRequest accountFilterRequest, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return PncBankUtil.getErrorList(bindResult);
		}
		
		return accountTransactionService.getAccountTransactionsByDate(accountFilterRequest);
	}
	
	@PostMapping("/getTransactionList/{pageNo}")
	public Object getAllTransactions(@PathVariable int pageNo, @Valid @RequestBody AccountFilterRequest accountFilterRequest, BindingResult bindResult) {
		if(bindResult.hasErrors()) {
			return PncBankUtil.getErrorList(bindResult);
		}
		
		return accountTransactionService.getAllAccountTransactions(accountFilterRequest, pageNo);
	}

}
