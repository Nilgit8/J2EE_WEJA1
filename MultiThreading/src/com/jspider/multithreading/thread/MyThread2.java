package com.jspider.multithreading.thread;

public class MyThread2 implements Runnable{
		public void run() {
			for(int i=1; i<=5 ; i++) {
				System.out.println("MyThread 2 is now running");
			}
		}
}
