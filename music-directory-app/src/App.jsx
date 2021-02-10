import './App.css';
import React, { useEffect, useState } from "react";
import Album from './Album.js';
import axios from 'axios';
import Alert from 'react-bootstrap/Alert'


const App = () => {

  //const [artists, setArtists] = useState([]);
  const [albums, setAlbums] = useState([]);
  const [search, setSearch] = useState("");
  const [query, setQuery] = useState('');

  const [name, setName] = useState("");
  const [year, setYear] = useState("");
  const [artist, setArtist] = useState("");
  const [cover, setCover] = useState("");

  const getAlbums = () => {
    axios.get(`http://localhost:9025/album/artist/${query}`)
      .then(res => {
        const data = res.data;
        console.log(data);
        setAlbums(data);
      })
  }

  const newAlbum = (e) => {   
    axios.post(`http://localhost:9025/album/newAlbum`, null, { params: {
          name,
          year,
          cover,
          artist
        }})
        .then(response => response.status)
        .catch(err => console.warn(err));
        <Alert variant={'success'}>{name} was added successfully!</Alert>
  }

  useEffect(() => {
    getAlbums();
  }, [query]);

  //updates search query
  const updateSearch = e => {
    setSearch(e.target.value);
    console.log(search);
  }

  const updateName = e => {
    setName(e.target.value);
    console.log(search);
  }

  const updateYear = e => {
    setYear(e.target.value);
    console.log(search);
  }

  const updateArtist = e => {
    setArtist(e.target.value);
    console.log(search);
  }

  const updateCover = e => {
    setCover(e.target.value);
    console.log(search);
  }

  //executes the search
  const getSearch = e => {
    e.preventDefault();
    setQuery(search);
    setSearch("");
  }

  return (
    <div className="App">
      <h1 style={{textAlign: 'center'}}>Welcome to the Music Directory App!</h1>
      <p style={{textAlign: 'center'}}>Currently enter the name of the artist to see all albums in the database</p>
      <form onSubmit={getSearch} className="search-form">
        <input className="search-bar" type="text" value={search} onChange={updateSearch} placeholder="Enter artist name"/>
        <button className="search-button" type="submit">Search</button>
      </form>
      <form onSubmit={newAlbum} className="insert-form">
        <input className="input" value={name} onChange={updateName} type="text" placeholder="Enter album name"/>
        <input className="input" value={year} onChange={updateYear} type="text" placeholder="Enter album release year"/>
        <input className="input" value={artist} onChange={updateArtist} type="text" placeholder="Enter artist name"/>
        <input className="input" value={cover} onChange={updateCover} type="text" placeholder="Enter album cover link"/>
        <button className="search-button" type="submit">Submit new album</button>
      </form>
      {/* use parentheses when returning React */}
      <div className="albums">
        {albums.map(albums => (
          <Album key={albums.albumID} name={albums.name} year={albums.year} image={albums.cover}/>
        ))}
      </div>
    </div>
  );
}

export default App;
