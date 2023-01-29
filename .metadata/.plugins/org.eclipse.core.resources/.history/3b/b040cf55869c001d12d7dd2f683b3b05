package com.jspider.multithreading.main;

import com.jspider.multithreading.thread.MyThread1;
import com.jspider.multithreading.thread.MyThread2;

public class ThreadMain {
	public static void main(String[] args) {
		MyThread1 thread1=new MyThread1();
		MyThread2 thread2=new MyThread2();
		
		Thread thread=new Thread(thread2);
		
		thread1.start();
		thread.start();
	}

}
