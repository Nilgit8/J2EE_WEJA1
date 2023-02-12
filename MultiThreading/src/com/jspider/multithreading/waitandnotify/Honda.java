package com.jspider.multithreading.waitandnotify;
 

public class Honda extends Thread {
	private Bike bike;
	public Honda (Bike bike) {
		this.bike=bike;
	}

	public void run() {
		bike.makeBike(10);
		
	}

}
