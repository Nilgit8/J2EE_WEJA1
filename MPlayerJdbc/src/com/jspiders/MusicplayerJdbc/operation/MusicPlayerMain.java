package com.jspiders.MusicplayerJdbc.operation;

import java.util.Scanner;

public class MusicPlayerMain {
	static Scanner sc = new Scanner(System.in);
	static boolean loop = true;

	public static void main(String[] args) {
		while (loop) {
			test();
		}
	}

	public static void test() {
		System.out.println("-------------------\n Menu \n-------------------- \n1.play song \n2.Add/Remove song "
				+ "\n3.Update song \n4.Exit \n--------------------");
		
		System.out.println("choose option : ");
		int choice=sc.nextInt();
		OperationSong operationSong=new OperationSong();
		switch (choice) {
		case 1:
			operationSong.playSong();
			break;
			
		case 2:
			operationSong.addRemove();
			break;
			
		case 3:
			operationSong.update();
			break;
			
		case 4:loop=false;
        System.out.println("Thank you");
			break;

		default:System.out.println("Invalid choice");
			break;
		}
}
	
}
