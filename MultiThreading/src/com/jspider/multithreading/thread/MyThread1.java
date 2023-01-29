package com.jspider.multithreading.thread;

import java.util.Iterator;

public class MyThread1 extends Thread{
	public void run() {
		for(int i=1 ;i<=5;i++ ) {
			System.out.println("Mythread 1 is now running");
		}
	}

}
