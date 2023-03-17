package com.jspiders.hibernate.DAO;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.TransactionalException;

import org.hibernate.TransactionException;

import com.jspiders.hibernate.DTO.Song;

public class SongOperation {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	static SongOperation operation = new SongOperation();
	static int choice;
	static Scanner sc = new Scanner(System.in);

	public static void openConnection() {
		factory = Persistence.createEntityManagerFactory("musicplayer");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction.isActive()) {
			transaction.rollback();
		}
//		if(transaction!=null) {
//			try {
//				transaction.rollback();
//			} catch (TransactionException e) {
//				System.out.println("Transaction is Commited");
//			}
//		}
	}
	public static void main(String[] args) {
		
		openConnection();
		transaction.begin();
		Song song=new Song();
		song.setName("KESARIYA");
		song.setAlbum("baa");
		song.setSinger("Baa");
		manager.persist(song);
		transaction.commit();
		closeConnection();
		
	}

}
