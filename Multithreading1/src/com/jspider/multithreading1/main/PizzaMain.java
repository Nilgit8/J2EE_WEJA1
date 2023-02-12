package com.jspider.multithreading1.main;

import com.jspider.multithreading1.resources.Pizza;
import com.jspider.multithreading1.thread.Dominos;
import com.jspider.multithreading1.thread.Friend;

public class PizzaMain {
	public static void main(String[] args) {
		Pizza pizza=new Pizza();
		
		Friend friend=new Friend(pizza);
		Dominos dominos=new Dominos(pizza);
		
		friend.start();
		dominos.start();
		
	}

}
