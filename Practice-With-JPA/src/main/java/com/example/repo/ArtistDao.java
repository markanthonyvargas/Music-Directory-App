package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Artist;

public interface ArtistDao extends JpaRepository<Artist, Integer>{
	public List<Artist> findAll();
	public Artist findByName(String name);
	public List<Artist> findByGenre(String genre);
}
