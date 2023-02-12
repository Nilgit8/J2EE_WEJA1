package com.jspiders.designpattern.task;

import com.jspiders.designpattern.account.Account;

public class Withdraw {
double withdrawAmount;
	public Withdraw(double withdrawamt) {
		this.withdrawAmount=withdrawamt;
		System.out.println("Withdwrawing amount "+withdrawAmount+" from the account");
		Account.accountBalance-=withdrawAmount;
		System.out.println("Total Balance : "+Account.accountBalance);
	}
	

}
