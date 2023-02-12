package com.jspider.multithreading1.thread;

import com.jspider.multithreading1.resources.Pizza;

public class Friend extends Thread{
	private Pizza pizza;

	public Friend(Pizza pizza) {
		this.pizza=pizza;
	}
	public void run() {
	pizza.ordered(5);
	}

}
