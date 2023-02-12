package com.jspiders.filehandling.main;

import java.io.File;
import java.io.IOException;

public class Filehandling1 {
	public static void main(String[] args) {
		File file=new File("test.pdf");
		try {
			file.createNewFile();
			System.out.println(file.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (file.exists()) {
			System.out.println("file is exist");
			
		}
		else {
			System.out.println("file not exist");
		}
		if (file.canRead()) {
			System.out.println("file is reaadable");
		}
		if (file.canExecute()) {
			System.out.println("file is executable");
		}
		if (file.canWrite()) {
			System.out.println("file is writable");
		}
	}

}
