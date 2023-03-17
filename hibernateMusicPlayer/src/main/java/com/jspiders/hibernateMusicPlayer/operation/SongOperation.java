package com.jspiders.hibernateMusicPlayer.operation;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.query.Query;

public class SongOperation {
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	static SongOperation operation = new SongOperation();
	static int choice;
	static Scanner sc = new Scanner(System.in);
	static boolean loop = true;
	
	private static javax.persistence.Query query;
	private static String jpqlQuery;

//	// Open connection common for all operations
	private static void openConnection() {
		factory = Persistence.createEntityManagerFactory("music");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();
	}

	// close connection common for operations
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
	}

	public void playsong() {
		System.out.println("------------------ \n1.Play all songs \n2.Choose song"
				+ " \n-------------------");
		System.out.println("choose option : ");
		 choice = sc.nextInt();
		 switch (choice) {
			case 1:System.out.println("All songs are playing");
					operation.allsongs();
					System.out.println("------------------------");
				break;
				
			case 2:
			operation.allsongs();
			operation.selectSong();
		        break;

			default:System.out.println("invalid input");
				break;
		 }
	}

	private void selectSong() {
		System.out.println("choose song-id for playing a song");
		int id=sc.nextInt();
		operation.openConnection();
		transaction.begin();
		Song song =manager.find(Song.class, id);
		System.out.println(song);
		System.out.println("the selected song is playing now");
		transaction.commit();
		closeConnection();
	}

	public void addRemove() {
		System.out.println(
				"-------------------- \n1.Add song \n2.Remove Song \n3.All Songs \n4.Go Back \n---------------");

		System.out.println("choose option : ");
		System.out.println("-------------------------");
		choice = sc.nextInt();
		switch (choice) {
		case 1:
			operation.addsong();
			System.out.println("0.Go back");
			choice = sc.nextInt();

			switch (choice) {
			case 0:
				operation.goBack();
				System.out.println("----------------------");
				break;
			default:
				System.out.println("Invalid input");
				break;
			}
		case 2:
			operation.removesong();
			System.out.println("0.Go back");
			choice = sc.nextInt();
			switch (choice) {
			case 0:
				operation.goBack();
				System.out.println("----------------------");
				break;
			}
		case 3:
			operation.allsongs();
			System.out.println("--------------------------");
			break;
		case 4:
			operation.goBack();
			System.out.println("--------------------------");
			break;
		default:
			System.out.println("Invalid input");
			break;
		}
	}

	private void allsongs() {
		operation.openConnection();
		transaction.begin();
		jpqlQuery="from Song";
		query=manager.createQuery(jpqlQuery);
		List<Song> songs=query.getResultList();
		for (Song song : songs) {
			System.out.println(song);	
		}
		transaction.commit();
		closeConnection();
	}

	private void addsong() {
		try {
			operation.openConnection();
			transaction.begin();
			Song song = new Song();
//			System.out.println("put song id");
//			int songid = sc.nextInt();
//			song.setId(songid);

			System.out.println("put song name");
			String songName = sc.next();
			song.setNameString(songName);
			System.out.println("put album name");
			String album = sc.next();
			System.out.println();
			song.setAlbumString(album);
			System.out.println("put singer name");
			String singer = sc.next();
			song.setSingerString(singer);
			manager.persist(song);
			transaction.commit();
		} finally {
			closeConnection();
		}
	}

	private void removesong() {
		System.out.println("put song id for remove");
		int songid = sc.nextInt();
		operation.openConnection();
		transaction.begin();
		Song song =manager.find(Song.class, songid);
		manager.remove(song);
		transaction.commit();
		closeConnection();
	}

	private void goBack() {
		operation.test();
	}

	public void update() {
		System.out.println("1.Update Song Name\n2.Update Album Name  \n3.Update Singer Name \n4.Go back");
		choice=sc.nextInt();
		
switch (choice) {
		case 1:
			System.out.println("put song id for update song name");
			int id=sc.nextInt();
			System.out.println("put song name");
			String name=sc.next();
		operation.openConnection();
		transaction.begin();
		Song song =manager.find(Song.class, id);
		song.setNameString(name);
		manager.persist(song);
		transaction.commit();
		closeConnection();
		break;
		
		case 2:
			System.out.println("put song id for update song");
			id=sc.nextInt();
			System.out.println("put album name for update song");
			String album=sc.next();
			operation.openConnection();
			transaction.begin();
		    song =manager.find(Song.class, id);
			song.setNameString(album);
			manager.persist(song);
			transaction.commit();
			closeConnection();
			break;
		
		case 3:
			System.out.println("put song id for update song");
			id=sc.nextInt();
			System.out.println("put singer name for update song");
			String singer=sc.next();
			operation.openConnection();
			transaction.begin();
		    song =manager.find(Song.class, id);
			song.setNameString(singer);
			manager.persist(song);
			transaction.commit();
			closeConnection();
			break;
			
		case 4:operation.goBack();
		System.out.println("-------------------------");
		default:System.out.println("invalid choice");
			break;
}
	}

	
	//main method
	public static void main(String[] args) {
		while (loop) {
			test();
		}
	}

	public static void test() {
		System.out.println("-------------------\n Menu \n-------------------- \n1.play song \n2.Add/Remove song "
				+ "\n3.Update song \n4.Exit \n--------------------");

		System.out.println("choose option : ");
		int choice = sc.nextInt();
		SongOperation operation = new SongOperation();
		switch (choice) {
		case 1:
			operation.playsong();
			break;

		case 2:
			operation.addRemove();
			break;

		case 3:
			operation.update();
			break;

		case 4:
			loop = false;
			System.out.println("Thank you");
			break;

		default:
			System.out.println("Invalid choice");
			break;
		}
	}

}
