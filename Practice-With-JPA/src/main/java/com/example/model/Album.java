package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="albums")
public class Album {
	
	@Id
	@Column(name="album_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int albumID;
	
	@Column(name="album_name")
	private String name;
	
	@Column(name="album_year")
	private int year;
	
	@Column(name="cover_link")
	private String cover;
	
	@ManyToOne
	@JoinColumn(name="artist_id", nullable=false)
	@JsonIgnore
	private Artist artist;
	
	public Album() {
		// TODO Auto-generated constructor stub
	}

	public Album(int albumID, String name, int year, String cover, Artist artist) {
		super();
		this.albumID = albumID;
		this.name = name;
		this.year = year;
		this.cover = cover;
		this.artist = artist;
	}

	public Album(String name, int year, String cover, Artist artist) {
		super();
		this.name = name;
		this.year = year;
		this.cover = cover;
		this.artist = artist;
	}

	public int getAlbumID() {
		return albumID;
	}

	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "Album [albumID=" + albumID + ", name=" + name + ", year=" + year + ", cover=" + cover + ", artist="
				+ artist.getName() + "]";
	}
	
	
}
