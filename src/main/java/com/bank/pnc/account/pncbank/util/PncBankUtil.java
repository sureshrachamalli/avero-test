package com.bank.pnc.account.pncbank.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class PncBankUtil {
	
	public static List<String> getErrorList(BindingResult br){
	       List<FieldError> errors = br.getFieldErrors();
	        List<String> message = new ArrayList<>();
	        for (FieldError e : errors){
	            message.add("@" + e.getField().toUpperCase() + ":" + e.getDefaultMessage());
	        }
	        return message;
	}
	
	/**
	 * input: "2021-01-31"
	 * output: Date object of given dateString
	 * @param args
	 */
	public static Date getDateFromStartDateString(String strDt) {
		Date dt = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
		try {
			 dt = (Date)formatter.parse(strDt+"T00:00:01");
		} catch (ParseException e) {
			e.printStackTrace();
			return dt;
		}
		return dt;
	}
	
	
	/**
	 * input: "2021-01-31"
	 * output: Date object of given dateString
	 * @param args
	 */
	public static Date getDateFromEndDateString(String strDt) {
		Date dt = null;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); 
		try {
			 dt = (Date)formatter.parse(strDt+"T23:59:59");
		} catch (ParseException e) {
			e.printStackTrace();
			return dt;
		}
		return dt;
	}
	
	public static void main(String args[]) {
		System.out.println(getDateFromEndDateString("2011-01-01"));
		System.out.println(getDateFromStartDateString("2011-01-01"));

	}
}
