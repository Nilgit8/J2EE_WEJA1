package com.jspider.multithreading.waitandnotify;

public class Bike extends Thread {
	int noOfBikes;
	
	public synchronized void orderedBike(int orderedBike) {
		System.out.println("Ordering "+ orderedBike +" Bikes.");
		if (orderedBike>noOfBikes) {
			System.out.println(orderedBike + " Bikes not available.");
			System.out.println("Please wait...!!!");
			try {
				this.wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		noOfBikes -= orderedBike;
		System.out.println("order of "+ orderedBike +" Bikes successfull");
	}
	
	public synchronized void makeBike(int readyBikes) {
		System.out.println("Production started of "+ readyBikes +" Bikes");
		noOfBikes += readyBikes;
		System.out.println(noOfBikes+" Bikes available");
		this.notify();
	}

	

}
