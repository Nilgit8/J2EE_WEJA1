package com.jspider.multithreading1.thread;

import java.util.ArrayList;

public class Demo {
	public static void main(String[] args) {
		ArrayList arrayList=new ArrayList();
		//System.out.println(arrayList.isEmpty());
		arrayList.add(1);
		arrayList.add("nilesh");
	//	System.out.println(arrayList.isEmpty());

		
	//	System.out.println(arrayList.size());
		ArrayList<String>arr=new ArrayList<String>();
		arr.add("desale");
		System.out.println(arr);
		System.out.println(arrayList);
	//	arrayList.addAll(arr);
	//	System.out.println(arrayList);
		arrayList.add(arr);
		System.out.println(arrayList);
	//	System.out.println(arrayList.contains(1));
		arrayList.remove(Integer.valueOf(1));
	//	System.out.println(arrayList);
	}
}
