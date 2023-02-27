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
		try {
			File file=new File("nil.txt");
			if (file.exists()) {
				System.out.println("file alredy exist");
			} else {
				file.createNewFile();
				System.out.println("file created");
			}
			FileOutputStream fileOutputStream=new FileOutputStream(file);
			FileInputStream fileInputStream=new FileInputStream(file);
			
			//serialization
			ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
			User user=new User(1, "NILESH","NIL@1999");
			objectOutputStream.writeObject(user);
			System.out.println("object is written");
			objectOutputStream.close();
			
			//deserialization
			ObjectInputStream inputStream=new ObjectInputStream(fileInputStream);
			User oUser=(User)inputStream.readObject();
			System.out.println(oUser);
			inputStream.close();
			
		} catch (Exception e) {
		}
		

}
}

	
