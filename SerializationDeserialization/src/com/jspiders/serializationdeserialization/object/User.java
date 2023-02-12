package com.jspiders.serializationdeserialization.object;

import java.io.Serializable;

public class User implements Serializable{
	

	
	 int id;
	 String username;
	 String password;

	public User(int id, String username, String password) {
		this.id=id;
		this.username=username;
		this.password=password;
		

	}
public String toString() {
	return "user[id="+id+",username="+username+",password="+password+"]";
	
}
}
