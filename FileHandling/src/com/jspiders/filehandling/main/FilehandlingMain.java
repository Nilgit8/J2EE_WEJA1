package com.jspiders.filehandling.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class FilehandlingMain {
	public static void main(String[] args) {
		File file=new File("Demo.txt");
		
				try {
					if (file.exists()) {
						System.out.println("file already exist");
						System.out.println("FILE PATH :"+file.getAbsolutePath());
					}else {
					file.createNewFile();
					System.out.println("created new file succefully");
					}
					
					if (file.canRead()) {
						System.out.println("file is readable");
					}
					else {
						System.out.println("file is unreadable");
					}
					if (file.canExecute()) {
						System.out.println("file is executable");
					}
					else {
						System.out.println("file is executable");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("file is not readable");
				}
				FileOutputStream fileOutputStream;
				try {
					fileOutputStream = new FileOutputStream(file);
						fileOutputStream.write(20);
						System.out.println("write successfully");
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					FileWriter fileWriter=new FileWriter(file);
					fileWriter.write("data from program");
					fileWriter.close();
					FileWriter fileWriter2 = new FileWriter(file);
					fileWriter2.write("NILESH DESALE");
					fileWriter2.write(" nilesh");
					fileWriter2.write(" 8");
					System.out.println("successfull");
					fileWriter2.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
	}

}
