package com.nilesh;

public class Songs {

	private int id;
	private String name;
	private String movie;
	private float length;
	private String singer;
	private String compose;
	private String lyrics;

//	public Songs(int id, String name, String movie, float length, String singer, String compose, String lyrics) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.movie = movie;
//		this.length = length;
//		this.singer = singer;
//		this.compose = compose;
//		this.lyrics = lyrics;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
			this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMovie() {
		return movie;
	}

	public void setMovie(String movie) {
		this.movie = movie;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getCompose() {
		return compose;
	}

	public void setCompose(String compose) {
		this.compose = compose;
	}

	public String getLyrics() {
		return lyrics;
	}

	public void setLyrics(String lyrics) {
		this.lyrics = lyrics;
	}

	@Override
	public String toString() {
		return name;
	}

}
