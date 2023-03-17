package com.jspiders.MusicplayerJdbc.operation;

public class SongInfo {
	private int id;
	private String nameString;
	private String albumString;
	private String singerString;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getAlbumString() {
		return albumString;
	}
	public void setAlbumString(String albumString) {
		this.albumString = albumString;
	}
	public String getSingerString() {
		return singerString;
	}
	public void setSingerString(String singerString) {
		this.singerString = singerString;
	}
	@Override
	public String toString() {
		return "SongInfo [id=" + id + ", nameString=" + nameString + ", albumString=" + albumString + ", singerString="
				+ singerString + "]";
	}

	
	
	  
	 
	  
	 
}
