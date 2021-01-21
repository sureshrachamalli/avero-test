package com.bank.pnc.account.pncbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.bank.pnc.account.pncbank")
public class PncBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(PncBankApplication.class, args);
	}

}
