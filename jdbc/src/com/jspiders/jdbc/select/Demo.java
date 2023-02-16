package com.jspiders.jdbc.select;


import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string="He is a very very good boy, isn't he?";
		scanner.close();
		String[] strings=string.split(" ");
		System.out.println(strings.length+1);
		for(int i=0;i<strings.length;i++) {
//			!=33 ,=44  ?=63 .=46  _=95  '=39  @=64
			char[] ch=strings[i].toCharArray();
			for(int j=0;j<ch.length;j++) {
				if (ch[j]=='\'' ) {
					System.out.println();
				}
				if (ch[j]=='!' || ch[j]==',' || ch[j]=='?' || ch[j]=='.' || ch[j]=='_' ||  ch[j]=='@' || ch[j]=='\'' ) {
					
				}else {
					System.out.print(ch[j]);
				}
			}
			System.out.println();
		}
	}
}
