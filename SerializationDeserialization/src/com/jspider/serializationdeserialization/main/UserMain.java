package com.jspider.serializationdeserialization.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.jspiders.serializationdeserialization.object.User;

public class UserMain {
	public static void main(String[] args) {
		User user=new User(1,"Aaitya","aditya123");
		File file=new File("file.txt");
		try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//SERIALIZATION
		try {
			FileOutputStream fileout=new FileOutputStream("file1.txt");
		
			 ObjectOutputStream	objectOut = new ObjectOutputStream(fileout);
			
			objectOut.writeObject(user);
			System.out.println("object written");
			objectOut.flush();
			objectOut.close();
		
			//DESERIALIZATION
			FileInputStream fileIn=new FileInputStream("file.txt");
			ObjectInputStream objectIn=new ObjectInputStream(fileIn);
			
			 User readObject = (User)objectIn.readObject();
			 
			System.out.println(readObject);
			objectIn.close();
			}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
