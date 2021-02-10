package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Artist;
import com.example.repo.ArtistDao;

@RestController
@RequestMapping("/artist")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ArtistController {
	@Autowired
	private ArtistDao artistDao;
	
	@GetMapping("/allArtists")
	public List<Artist> findAllArtists() {
		return artistDao.findAll();
	}
	
	@PostMapping("/newArtist")
	public String insertArtist(@RequestBody Artist artist) {
		artistDao.save(artist);
		return "success";
	}
}
