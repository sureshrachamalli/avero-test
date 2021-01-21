package com.bank.pnc.account.pncbank.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.bank.pnc.account.pncbank.dto.AccountFilterRequest;
import com.bank.pnc.account.pncbank.dto.AccountTransactionsRequest;
import com.bank.pnc.account.pncbank.dto.AccountTransactionsResponse;
import com.bank.pnc.account.pncbank.entity.AccountEntity;
import com.bank.pnc.account.pncbank.entity.AccountTransactionEntity;
import com.bank.pnc.account.pncbank.repository.AccountBalanceRepo;
import com.bank.pnc.account.pncbank.repository.AccountTransactionRepo;
import com.bank.pnc.account.pncbank.util.PncBankUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AccountTransactionService {

	@Autowired
	private AccountTransactionRepo accountTransactionRepo;
	
	@Autowired
	private AccountBalanceRepo accountBalanceRepo;
	
	public AccountTransactionsResponse createAccountTransaction(AccountTransactionsRequest accountTransactionRequest) {
		AccountTransactionsResponse accountTransactionsResponse = null;
		try {
			List<AccountEntity> accountEntityList = accountBalanceRepo.findByAccountNumber(accountTransactionRequest.getAccountNumber());
			if(null != accountEntityList && accountEntityList.size() > 0 ) {
				AccountEntity accountEntity = accountEntityList.get(0);
				
				if(accountTransactionRequest.getTransactionType().equalsIgnoreCase("W") && 
						accountEntity.getBalance() >=  accountTransactionRequest.getAmount()) {
					AccountTransactionEntity accountTransactionEntity = mapAccountTransEntity(accountTransactionRequest);
					try {
						accountTransactionEntity = accountTransactionRepo.save(accountTransactionEntity);
						accountBalanceRepo.save(mapAccountEntity(accountEntity, accountTransactionRequest));
						accountTransactionsResponse = new AccountTransactionsResponse(accountTransactionRequest, Boolean.TRUE, "");
					}catch(Exception e) {
						accountTransactionsResponse = new AccountTransactionsResponse(accountTransactionRequest, Boolean.FALSE, "Unknow Exception :: "+e.getMessage());
					}
					
				}else if(accountTransactionRequest.getTransactionType().equalsIgnoreCase("D")) {
					AccountTransactionEntity accountTransactionEntity = mapAccountTransEntity(accountTransactionRequest);
					try {
						accountTransactionEntity = accountTransactionRepo.save(accountTransactionEntity);
						accountBalanceRepo.save(mapAccountEntity(accountEntity, accountTransactionRequest));
						accountTransactionsResponse = new AccountTransactionsResponse(accountTransactionRequest, Boolean.TRUE, "");
					}catch(Exception e) {
						accountTransactionsResponse = new AccountTransactionsResponse(accountTransactionRequest, Boolean.FALSE, "Unknow Exception :: "+e.getMessage());
					}
				}else {
					accountTransactionsResponse = new AccountTransactionsResponse(accountTransactionRequest, Boolean.FALSE, "Insufficient Funds to withdraw.");
				}
					
			}else {
				accountTransactionsResponse = new AccountTransactionsResponse(accountTransactionRequest, Boolean.FALSE, "Account Does not Esists.");
			}
		}catch(Exception e) {
			accountTransactionsResponse = new AccountTransactionsResponse(accountTransactionRequest, Boolean.FALSE, "Unknow Error :: "+e.getMessage());
		}
		
		return accountTransactionsResponse;
	}
	
	private AccountTransactionEntity mapAccountTransEntity(AccountTransactionsRequest accountTransactionRequest) {
		AccountTransactionEntity accountTransactionEntity = new AccountTransactionEntity();
		accountTransactionEntity.setAccountNumber(accountTransactionRequest.getAccountNumber());
		
		if(accountTransactionRequest.getTransactionType().equalsIgnoreCase("W")) {
			accountTransactionEntity.setTransactionType("WITHDRAW");
		}else if(accountTransactionRequest.getTransactionType().equalsIgnoreCase("D")) {
			accountTransactionEntity.setTransactionType("DEPOSIT");
		}
		
		accountTransactionEntity.setTransactionAmount(accountTransactionRequest.getAmount());
		accountTransactionEntity.setCreatedBy("ADMIN");
		accountTransactionEntity.setCreatedDate(new Date());
		return accountTransactionEntity;
	}

	private AccountEntity mapAccountEntity(AccountEntity accountEntity, AccountTransactionsRequest accountTransactionRequest) {
		if(accountTransactionRequest.getTransactionType().equalsIgnoreCase("D")) {
			accountEntity.setBalance(accountEntity.getBalance() + accountTransactionRequest.getAmount());
		}else if(accountTransactionRequest.getTransactionType().equalsIgnoreCase("W")){
			accountEntity.setBalance(accountEntity.getBalance() - accountTransactionRequest.getAmount());
		}
		accountEntity.setUpdatedBy("Admin");
		accountEntity.setUpdatedDate(new Date());
		return accountEntity;
	}
	
	public List<AccountTransactionEntity> getAccountTransactionsByType(AccountFilterRequest accountFilterRequest){
		List<AccountTransactionEntity> accountEntityList = new ArrayList<>();
		try {
			
			accountEntityList = accountTransactionRepo.findByAccountNumberAndTransactionType(accountFilterRequest.getAccountNumber(), 
					accountFilterRequest.getTransactionType().equalsIgnoreCase("W")?"WITHDRAW":"DEPOSIT");
		}catch(Exception e) {
			System.out.println("Error occured :: " +e.getMessage());
			return accountEntityList;
		}
		
		return accountEntityList;
	}
	
	public List<AccountTransactionEntity> getAccountTransactionsByDate(AccountFilterRequest accountFilterRequest){
		List<AccountTransactionEntity> accountEntityList = new ArrayList<>();
		try {
			
			accountEntityList = accountTransactionRepo.findByAccountNumberAndCreatedDate(accountFilterRequest.getAccountNumber(), 
					PncBankUtil.getDateFromStartDateString(accountFilterRequest.getStartDate()),
					PncBankUtil.getDateFromEndDateString(accountFilterRequest.getEndDate()));
		}catch(Exception e) {
			log.error("Error occured :: " +e.getMessage());
			System.out.println("Error occured :: " +e.getMessage());
			return accountEntityList;
		}
		
		return accountEntityList;
	}
	
	@SuppressWarnings("deprecation")
	public List<AccountTransactionEntity> getAllAccountTransactions(AccountFilterRequest accountFilterRequest, int pageNum){
		List<AccountTransactionEntity> accountEntityList = new ArrayList<>();
		try {
			accountEntityList = accountTransactionRepo.findByAccountNumber(accountFilterRequest.getAccountNumber(), new PageRequest(pageNum, 5));
		}catch(Exception e) {
			System.out.println("Error occured :: " +e.getMessage());
			return accountEntityList;
		}
		return accountEntityList;
	}
	
}
