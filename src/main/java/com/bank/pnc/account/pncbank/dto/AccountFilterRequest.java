package com.bank.pnc.account.pncbank.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AccountFilterRequest {
	
	@NotNull(message="Account Number must not blank.")
	@Min(value = 10000, message = "Account Number Length must be 5.")
	@Max(value = 99999, message = "Account Number Length must be 5.")
	private Integer accountNumber;
	
	private String startDate;   //can write pattern validation for DateFormat to be entered
	private String endDate;
	
	//@NotEmpty(message="TransactionType must not blank.")	
	@Pattern(regexp = "^[D|W|d|w]{1}$", message ="Transaction Type Must be D or d or W or w.")
	private String transactionType;
}
