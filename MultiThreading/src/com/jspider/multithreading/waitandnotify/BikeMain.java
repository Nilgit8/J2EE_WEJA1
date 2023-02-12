package com.jspider.multithreading.waitandnotify;


public class BikeMain {
	public static void main(String[] args) {
		
		
		Customer customer=new Customer(bike);
		Honda honda=new Honda(bike);
		
		customer.start();
		honda.start();
		
	}
}
