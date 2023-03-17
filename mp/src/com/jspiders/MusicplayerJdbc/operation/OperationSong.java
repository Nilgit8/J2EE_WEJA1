package com.jspiders.MusicplayerJdbc.operation;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;


public class OperationSong {
	static Scanner sc = new Scanner(System.in);
	
	private static String filepath ="D:\\Qsp course\\WEJA1_J2EE\\MusicPlayerJdbc\\src\\resources\\db_info.properties";
	  private static FileReader fileReader;
	  private static Properties properties;
	  private static Connection connection;
	  private static Statement statement;
	  private static int result;
	  private static String query;
	  private static ResultSet resultSet;
	  static int choice;
	  private static PreparedStatement preparedStatement;
	

	public void playSong() {
		System.out.println("------------------ \n1.Play all songs \n2.Choose song"
				+ " \n-------------------");
		System.out.println("choose option : ");
		 choice = sc.nextInt();
		OperationSong operationSong=new OperationSong();
				
		switch (choice) {
		case 1:System.out.println("All songs are playing");
				operationSong.allsongs();
				System.out.println("------------------------");
			break;
			
		case 2:
		operationSong.allsongs();
		operationSong.selectSong();
	        break;

		default:System.out.println("invalid input");
			break;
		}
	}

	private void selectSong() {
		OperationSong operationSong=new OperationSong();
		System.out.println("choose song-id for playing a song");
		int id=sc.nextInt();
		
		operationSong.connection();
		try {
         statement=connection.createStatement();
		query="select * from musicplayer where id="+id;
			operationSong.result();
		}
			 catch (SQLException e) {
			    	e.printStackTrace();
			    }
		    
		   
		System.out.println("song is playing now");
			System.out.println("--------------------------");
			System.out.println();
	}
	

	public void addRemove() {
		System.out.println("-------------------- \n1.Add song \n2.Remove Song \n3.All Songs \n4.Go Back \n---------------");
		
		System.out.println("choose option : ");
		System.out.println("-------------------------");
		OperationSong operationSong=new OperationSong();
		 choice = sc.nextInt();
		 
		 switch (choice) {
		case 1:operationSong.addsong();
			   System.out.println("0.Go back");
			   choice = sc.nextInt();

			switch (choice) {
			case 0:
				operationSong.goBack();
				System.out.println("----------------------");
				break;
			default:System.out.println("Invalid input");
			break;
			}
		case 2:operationSong.removesong();
			   System.out.println("0.Go back");
			   choice = sc.nextInt();
			   switch (choice) {
				case 0:
					operationSong.goBack();
					System.out.println("----------------------");
					break;
			   }
		case 3:operationSong.allsongs();
		System.out.println("--------------------------");
		break;
		case 4:operationSong.goBack();
		System.out.println("--------------------------");
		break;
		default:System.out.println("Invalid input");
			break;
			}
			}
	
	

	private void allsongs() {
		OperationSong operationSong=new OperationSong();
		operationSong.connection();
		try {
			statement=connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			query="select * from musicplayer";
			operationSong.result();
	}

	private void removesong() {
		OperationSong operationSong=new OperationSong();
		operationSong.connection();
		System.out.println("put id for remove song");
		int id=sc.nextInt();
	
		query="delete from musicplayer where id=?";
		try {
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			result=preparedStatement.executeUpdate();
			System.out.println("Query ok "+result+" row(s) affected");
			System.out.println("--------------------------");
			System.out.println();
			operationSong.connection();
			try {
				statement=connection.createStatement();
			} 
			 catch (SQLException e) {
				e.printStackTrace();
			}
			query="select * from musicplayer";
			operationSong.result();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	private void goBack() {
		MusicPlayerMain.test();
	}

	private void addsong() {
		SongInfo info=new SongInfo();
		System.out.println("put song id");
		int songid = sc.nextInt();
		info.setId(songid);
		
		System.out.println("put song name");
		String songName = sc.next();
		info.setNameString(songName);
		
		System.out.println("put album name");
		String album = sc.next();
		info.setAlbumString(album);
		
		System.out.println("put singer name");
		String singer = sc.next();
		info.setSingerString(singer);
		
		OperationSong operationSong=new OperationSong();
		operationSong.connection();
		query="insert into musicplayer values(?,?,?,?)";
		
		try {
			preparedStatement=connection.prepareStatement(query);
			
		preparedStatement.setInt(1, info.getId());
		preparedStatement.setString(2, info.getNameString());
		preparedStatement.setString(3, info.getAlbumString());
		preparedStatement.setString(4, info.getSingerString());
		
		result=preparedStatement.executeUpdate();
		System.out.println("Query ok "+result+" row(s) affected");
		System.out.println("-----------------------");
		System.out.println();
		operationSong.connection();
		try {
			statement=connection.createStatement();
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		}
		query="select * from musicplayer";
		operationSong.result();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update() {
		
		System.out.println("1.Update Album Name \n2.Update Singer Name \n3.Update Song Name \n4.Go back");
		choice=sc.nextInt();
		OperationSong operationSong=new OperationSong();
		operationSong.connection();
		switch (choice) {
		
		case 1:
			System.out.println("put song id for update song");
			int id=sc.nextInt();
			System.out.println("put album name for update song");
			String album=sc.next();
			query="update musicplayer set album=? where id=?";
			try {
				preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, album);
			preparedStatement.setInt(2, id);
			result=preparedStatement.executeUpdate();
			System.out.println("Query ok "+result+" row(s) affected");
			System.out.println("--------------------------");
			System.out.println();
				statement=connection.createStatement();
			query="select * from musicplayer";
			operationSong.result();
			System.out.println();
			}
	        catch (SQLException e) {
	        	e.printStackTrace();
			}
			break;
			
		case 2:
			System.out.println("put song id for update song");
			id=sc.nextInt();
			System.out.println("put singer name for update song");
			String singer=sc.next();
			query="update musicplayer set singer=? where id=?";
			try {
				preparedStatement=connection.prepareStatement(query);
			
			preparedStatement.setString(1, singer);
			preparedStatement.setInt(2, id);
			result=preparedStatement.executeUpdate();
			System.out.println("Query ok "+result+" row(s) affected");
			System.out.println("------------------------");
			System.out.println();
				statement=connection.createStatement();
			query="select * from musicplayer";
			operationSong.result();
			System.out.println();
			}
	        catch (SQLException e) {
	        	e.printStackTrace();
			}
			break;
			
		case 3:
			System.out.println("put song id for update song");
			 id=sc.nextInt();
			System.out.println("put album name for update song");
			String songString=sc.next();
			query="update musicplayer set song=? where id=?";
			try {
				preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, songString);
			preparedStatement.setInt(2, id);
			result=preparedStatement.executeUpdate();
			System.out.println("Query ok "+result+" row(s) affected");
			System.out.println("--------------------------");
			System.out.println();
				statement=connection.createStatement();
			query="select * from musicplayer";
			operationSong.result();
			System.out.println();
			}
	        catch (SQLException e) {
	        	e.printStackTrace();
			}
			break;
			

		case 4:operationSong.goBack();
		System.out.println("-------------------------");
		default:System.out.println("invalid choice");
			break;
		}
		
	}
	
	 public void connection() {
		  try {
			fileReader=new FileReader(filepath);
			properties=new Properties();
			properties.load(fileReader);
			
			Class.forName(properties.getProperty("driverpath"));
			connection=DriverManager.getConnection(properties.getProperty("dburl"),properties);
			
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		  
	  }
	
	 public void result() {
		  try {
			resultSet=statement.executeQuery(query);
			 while (resultSet.next()) {
					System.out.println(resultSet.getString(1)+" ||   "
			 +resultSet.getString(2));
				}
		  } catch (SQLException e) {
				e.printStackTrace();
			}
		  finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (fileReader != null) {
						fileReader.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
	

}
