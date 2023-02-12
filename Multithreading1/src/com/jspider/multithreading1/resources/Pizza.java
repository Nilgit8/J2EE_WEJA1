package com.jspider.multithreading1.resources;

public class Pizza {
	int noOfPizza;
	
	public synchronized void ordered(int orderedPizza) {
		System.out.println("ordering "+orderedPizza+" pizzas" );
		if(noOfPizza<orderedPizza) {
			System.out.println(orderedPizza+" pizzas not awailable");
			System.out.println("please wait......!!!!");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		noOfPizza=noOfPizza-orderedPizza;
		System.out.println("order of "+orderedPizza+" pizzas successfully");
		
	}
	public synchronized void make(int makingPizza) {
		System.out.println("Making "+ makingPizza +" pizzas" );
		noOfPizza=noOfPizza+makingPizza;
		System.out.println("your order of "+ makingPizza +" pizzas is ready");
		this.notify();
	}

}
