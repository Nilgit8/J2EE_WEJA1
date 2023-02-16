package com.nilesh;


public class Demo {
public static void main(String[] args) {
 for(int row=1;row<=5;row++) {
	 for(int column=1;column<=17;column++) {
		 if (column<=6) {
			if (column==5 || column==1 || row==column) {
				System.out.print("* ");
			}
			else {
				System.out.print("  ");
			}
		 }
		 
		 else if (column>6 && column<=11) {
			if (row==1 || row==5 || column==9) {
				
				System.out.print("* ");
			}
			else {
				System.out.print("  ");
			}
		}
			
		 else if (column>12 && column<=17) {
			if (column==13 || row==5) {
				System.out.print(" *");
			}
			else {
				System.out.print("  ");
			}
			
		}
 }
	 System.out.println();
}
}
}



