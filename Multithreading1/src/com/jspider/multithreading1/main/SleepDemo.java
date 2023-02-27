package com.jspider.multithreading1.main;

import java.util.Iterator;

public class SleepDemo {

public static void main(String[] args) {
	String name="Nilesh Pandit Desale";
	char[] message=name.toCharArray();
	for (int i=0; i<name.length() ; i++) {
		System.out.print(message[i]);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
}
