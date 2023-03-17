package com.jspiders.hibernateMusicPlayer.operation;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Table;

import lombok.Data;

@Data
@Entity
@javax.persistence.Table(name="musicplayer")
public class Song {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name="song")
	private String nameString;
	@Column(name="album")
	private String albumString;
	@Column(name="singer")
	private String singerString;
	@Override
	public String toString() {
		return "Song [id=" + id + ", nameString=" + nameString + ", albumString=" + albumString + ", singerString="
				+ singerString + "]";
	}
}
 