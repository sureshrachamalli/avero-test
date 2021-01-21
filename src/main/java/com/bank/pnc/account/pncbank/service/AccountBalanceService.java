package com.bank.pnc.account.pncbank.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.pnc.account.pncbank.dto.AccountFilterRequest;
import com.bank.pnc.account.pncbank.dto.AccountRequest;
import com.bank.pnc.account.pncbank.dto.AccountResponse;
import com.bank.pnc.account.pncbank.entity.AccountEntity;
import com.bank.pnc.account.pncbank.repository.AccountBalanceRepo;

@Service
public class AccountBalanceService {

	@Autowired
	private AccountBalanceRepo accountBalanceRepo;
	
	public AccountResponse saveAccount(AccountRequest accountRequest) {
		AccountResponse accountResponse = null;
		AccountEntity accountEntity = mapAccountDetails(accountRequest);
		try {
			List<AccountEntity> accountEntityList =accountBalanceRepo.findByAccountNumber(accountRequest.getAccountNumber());

			if(accountEntityList != null && accountEntityList.size() <= 0) {
				try {
				 accountEntity = accountBalanceRepo.save(accountEntity);
				}catch(Exception e) {
					accountResponse = new AccountResponse(accountEntity, Boolean.FALSE, e.getMessage());
				}
				if(accountEntity.getId() > 0) {
					accountResponse = new AccountResponse(accountEntity, Boolean.TRUE, "");
				}else {
					accountResponse = new AccountResponse(accountEntity, Boolean.FALSE, "Unknown Exception Occured.");
				}
			}else {
				accountResponse = new AccountResponse(accountEntity, Boolean.FALSE, "Account Already Exists.");
			}
			
		}catch(Exception e) {
			accountResponse = new AccountResponse(accountEntity, Boolean.FALSE, e.getMessage());
		}
		
		return accountResponse;
	}

	private AccountEntity mapAccountDetails(AccountRequest accountRequest) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setAccountNumber(accountRequest.getAccountNumber());
		accountEntity.setBalance(accountRequest.getBalance());
		accountEntity.setCreatedBy("Admin");
		accountEntity.setCreatedDate(new Date());
		accountEntity.setUpdatedBy("Admin");
		accountEntity.setUpdatedDate(new Date());
		
		return accountEntity;
	}
	
	public Object getAccountBalance(AccountFilterRequest accountFilterRequest) {
		try {
			List<AccountEntity> accountEntityList = accountBalanceRepo.findByAccountNumber(accountFilterRequest.getAccountNumber());
			if(null != accountEntityList && accountEntityList.size() > 0){
				return accountEntityList.get(0).getBalance();
			}else {
				return "Account NotFound..";
			}
		}catch(Exception e) {
			return "Unknown Error :: "+e.getMessage();
		}
	}
	
	public List<Integer> getAccountList(){
		Iterable<AccountEntity> accountEntityList = accountBalanceRepo.findAll();
		List<Integer> accountList = new ArrayList<>();
		accountEntityList.forEach(x -> accountList.add(x.getAccountNumber()));
		return accountList;
		
	}
}
