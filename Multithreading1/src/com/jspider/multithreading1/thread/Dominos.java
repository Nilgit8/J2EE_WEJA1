package com.jspider.multithreading1.thread;

import com.jspider.multithreading1.resources.Pizza;

public class Dominos extends Thread{
	private Pizza pizza;

	public Dominos(Pizza pizza) {
		this.pizza=pizza;
	}
	public void run() {
	pizza.make(5);
	}
	

}
