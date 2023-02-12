package com.jspider.multithreading.waitandnotify;

public class Customer extends Thread {
	private Bike bike;
	public Customer (Bike bike) {
		this.bike=bike;
	}

	public void run() {
		bike.orderedBike(10);
	}

}
