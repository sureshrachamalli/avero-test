package com.bank.pnc.account.pncbank.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ACCOUNT_TRANSACTIONS")
@Data
public class AccountTransactionEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Integer accountNumber;
	
	private String transactionType;
	
	private double transactionAmount;
	
	private String createdBy;
	
	private Date createdDate;
}
