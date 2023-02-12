package com.jspiders.designpattern.task;

import com.jspiders.designpattern.account.Account;

public class Deposit {
	double depositAmount;
	public Deposit(double depositamt) {
		this.depositAmount=depositamt;
		System.out.println("Depositing "+depositAmount +" in the account");
		Account.accountBalance+=depositAmount;
		System.out.println("Total Balance : "+Account.accountBalance);
	}


}
