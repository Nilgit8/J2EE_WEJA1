package com.jspiders.designpattern.main;

import java.util.Scanner;

import com.jspiders.designpattern.account.Account;
import com.jspiders.designpattern.task.CheckBalance;
import com.jspiders.designpattern.task.Deposit;
import com.jspiders.designpattern.task.Withdraw;

public class AccountMain {
	static boolean loop = true;
	public static void main(String[] args) {
         Account account=new Account();
		System.out.println(account);
	
			Scanner scanner=new Scanner(System.in);
while (loop) {
	System.out.println("=====Choose Transaction=====");
	System.out.println("1.Deposit \n"+"2.Withdraw \n"+"3.Check Balance \n"+"4.Exit");
	
	
	int choice=scanner.nextInt();
	
	switch (choice) {
	case 1:
		System.out.println("Enter Deposit amount");
		double depositamt=scanner.nextDouble();
		Deposit deposit=new Deposit(depositamt);
		break;
	case 2:
		System.out.println("Enter Withdraw amount");
		double withdrawamt=scanner.nextDouble();
		Withdraw withdraw=new Withdraw(withdrawamt);
		break;
	case 3:
		CheckBalance checkBalance=new CheckBalance();
		checkBalance.Check();
		break;
	case 4:
		System.out.println("Thank You");
		loop=false;
		scanner.close();
		break;

	default:
		System.out.println("invalid choice");
		break;
	}
	
}
	}

}
