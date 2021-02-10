package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Album;
import com.example.model.Artist;
import com.example.repo.AlbumDao;
import com.example.repo.ArtistDao;

@RestController
@RequestMapping("/album")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AlbumController {
	
	@Autowired
	private AlbumDao albumDao;
	
	@Autowired
	private ArtistDao artistDao;
	
	@GetMapping
	public List<Album> getAllAlbums() {
		return albumDao.findAll();
	}
	
	@GetMapping("/artist/{artist}")
	public List<Album> findAlbumsByArtist(@PathVariable String artist) {
		Artist a = artistDao.findByName(artist);
		return albumDao.findByArtistOrderByYear(a);
	}
	
	@PostMapping("/newAlbum")
	public String insertAlbum(@RequestParam String name, @RequestParam int year, @RequestParam String artist, @RequestParam String cover) {
		Artist a = artistDao.findByName(artist);
		if(a == null) {
			a = new Artist(artist, "", null);
			System.out.println(a);
			artistDao.save(a);
		}
		albumDao.save(new Album(name, year, cover, a));
		return "success";
	}
}
