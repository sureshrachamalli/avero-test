package com.bank.pnc.account.pncbank.dto;

import lombok.Data;

@Data
public class AccountTransactionsResponse {
	
	private AccountTransactionsRequest accountTransactionsRequest;
	private boolean isSuccess;
	private String errorMsg;
	
	public AccountTransactionsResponse(AccountTransactionsRequest accountTransactionsRequest, boolean isSuccess,
			String errorMsg) {
		super();
		this.accountTransactionsRequest = accountTransactionsRequest;
		this.isSuccess = isSuccess;
		this.errorMsg = errorMsg;
	}
	
	
}
