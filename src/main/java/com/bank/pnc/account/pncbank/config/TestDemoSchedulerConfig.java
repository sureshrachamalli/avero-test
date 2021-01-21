package com.bank.pnc.account.pncbank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.bank.pnc.account.pncbank.dto.AccountRequest;
import com.bank.pnc.account.pncbank.dto.AccountTransactionsRequest;
import com.bank.pnc.account.pncbank.service.AccountBalanceService;
import com.bank.pnc.account.pncbank.service.AccountTransactionService;

@Configuration
@EnableScheduling
public class TestDemoSchedulerConfig {

	@Autowired
	private AccountBalanceService accountBalanceService;
	
	@Autowired 
	private AccountTransactionService accountTransactionService;
	
	@Scheduled(fixedDelay = 300000)
	public void setDemoData() {
		AccountRequest acR1 = new AccountRequest(12341, 100.0);
		accountBalanceService.saveAccount(acR1);
		AccountRequest acR2 = new AccountRequest(12342, 100.0);
		accountBalanceService.saveAccount(acR2);
		AccountRequest acR3 = new AccountRequest(12343, 100.0);
		accountBalanceService.saveAccount(acR3);
		AccountRequest acR4 = new AccountRequest(12344, 100.0);
		accountBalanceService.saveAccount(acR4);
		AccountRequest acR5 = new AccountRequest(12345, 100.0);
		accountBalanceService.saveAccount(acR5);
		AccountRequest acR6 = new AccountRequest(12346, 100.0);
		accountBalanceService.saveAccount(acR6);
		
		//Test Transactions creating...
		createTransaction(new AccountTransactionsRequest(12341, "D", 150.0));
		createTransaction(new AccountTransactionsRequest(12341, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12341, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12341, "W", 100.0));
		createTransaction(new AccountTransactionsRequest(12341, "D", 350.0));
		createTransaction(new AccountTransactionsRequest(12341, "D", 50.0));
		createTransaction(new AccountTransactionsRequest(12341, "W", 450.0));
		createTransaction(new AccountTransactionsRequest(12341, "D", 550.0));
		createTransaction(new AccountTransactionsRequest(12341, "D", 650.0));
		createTransaction(new AccountTransactionsRequest(12341, "W", 750.0));
		createTransaction(new AccountTransactionsRequest(12341, "D", 850.0));
		
		createTransaction(new AccountTransactionsRequest(12342, "D", 150.0));
		createTransaction(new AccountTransactionsRequest(12342, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12342, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12342, "W", 100.0));
		createTransaction(new AccountTransactionsRequest(12342, "D", 350.0));
		createTransaction(new AccountTransactionsRequest(12342, "D", 50.0));
		createTransaction(new AccountTransactionsRequest(12342, "W", 450.0));
		createTransaction(new AccountTransactionsRequest(12342, "D", 550.0));
		createTransaction(new AccountTransactionsRequest(12342, "D", 650.0));
		createTransaction(new AccountTransactionsRequest(12342, "W", 750.0));
		createTransaction(new AccountTransactionsRequest(12342, "D", 850.0));
		
		createTransaction(new AccountTransactionsRequest(12343, "D", 150.0));
		createTransaction(new AccountTransactionsRequest(12343, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12343, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12343, "W", 100.0));
		createTransaction(new AccountTransactionsRequest(12343, "D", 350.0));
		createTransaction(new AccountTransactionsRequest(12343, "D", 50.0));
		createTransaction(new AccountTransactionsRequest(12343, "W", 450.0));
		createTransaction(new AccountTransactionsRequest(12343, "D", 550.0));
		createTransaction(new AccountTransactionsRequest(12343, "D", 650.0));
		createTransaction(new AccountTransactionsRequest(12343, "W", 750.0));
		createTransaction(new AccountTransactionsRequest(12343, "D", 850.0));
		
		createTransaction(new AccountTransactionsRequest(12344, "D", 150.0));
		createTransaction(new AccountTransactionsRequest(12344, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12344, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12344, "W", 100.0));
		createTransaction(new AccountTransactionsRequest(12344, "D", 350.0));
		createTransaction(new AccountTransactionsRequest(12344, "D", 50.0));
		createTransaction(new AccountTransactionsRequest(12344, "W", 450.0));
		createTransaction(new AccountTransactionsRequest(12344, "D", 550.0));
		createTransaction(new AccountTransactionsRequest(12344, "D", 650.0));
		createTransaction(new AccountTransactionsRequest(12344, "W", 750.0));
		createTransaction(new AccountTransactionsRequest(12344, "D", 850.0));
		
		createTransaction(new AccountTransactionsRequest(12345, "D", 150.0));
		createTransaction(new AccountTransactionsRequest(12345, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12345, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12345, "W", 100.0));
		createTransaction(new AccountTransactionsRequest(12345, "D", 350.0));
		createTransaction(new AccountTransactionsRequest(12345, "D", 50.0));
		createTransaction(new AccountTransactionsRequest(12345, "W", 450.0));
		createTransaction(new AccountTransactionsRequest(12345, "D", 550.0));
		createTransaction(new AccountTransactionsRequest(12345, "D", 650.0));
		createTransaction(new AccountTransactionsRequest(12345, "W", 750.0));
		createTransaction(new AccountTransactionsRequest(12345, "D", 850.0));
		
		createTransaction(new AccountTransactionsRequest(12346, "D", 150.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12346, "W", 100.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 350.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 50.0));
		createTransaction(new AccountTransactionsRequest(12346, "W", 450.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 550.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 650.0));
		createTransaction(new AccountTransactionsRequest(12346, "W", 750.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 850.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 150.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 250.0));
		createTransaction(new AccountTransactionsRequest(12346, "W", 100.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 350.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 50.0));
		createTransaction(new AccountTransactionsRequest(12346, "W", 450.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 550.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 650.0));
		createTransaction(new AccountTransactionsRequest(12346, "W", 750.0));
		createTransaction(new AccountTransactionsRequest(12346, "D", 850.0));
	}
	
	private void createTransaction(AccountTransactionsRequest accTrxRequest) {
		accountTransactionService.createAccountTransaction(accTrxRequest);
	}
}
