package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Album;
import com.example.model.Artist;

public interface AlbumDao extends JpaRepository<Album, Integer> {
	public List<Album> findAll();
	public List<Album> findByArtist(Artist artist);
	public List<Album> findByArtistOrderByYear(Artist artist);
	public List<Album> findByYear(int year);
}
