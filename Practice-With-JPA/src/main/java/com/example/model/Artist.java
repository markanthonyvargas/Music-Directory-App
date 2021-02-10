package com.example.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="artists")
public class Artist {
	
	@Id
	@Column(name="artist_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int artistID;
	
	@Column(name="artist_name", unique=true, nullable=false)
	private String name;
	
	@Column(name="genre", unique=false, nullable=true)
	private String genre;
	
	@OneToMany(mappedBy="artist")
	private Set<Album> albums;
	
	public Artist() {
		// TODO Auto-generated constructor stub
	}

	public Artist(int artistID, String name, String genre, Set<Album> albums) {
		super();
		this.artistID = artistID;
		this.name = name;
		this.genre = genre;
		this.albums = albums;
	}

	public Artist(String name, String genre, Set<Album> albums) {
		super();
		this.name = name;
		this.genre = genre;
		this.albums = albums;
	}

	public int getArtistID() {
		return artistID;
	}

	public void setArtistID(int artistID) {
		this.artistID = artistID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	@Override
	public String toString() {
		return "Artist [artistID=" + artistID + ", name=" + name + ", genre=" + genre + ", albums=" + albums + "]";
	}
}
