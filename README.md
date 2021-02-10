# Music-Directory-App

## Project Description

The Music Directory App serves as a music library database. Users can search albums by entering an artist's name, as well as enter new albums in the database. In the future, users will also be able to search by album name, as well as view artist profiles.

## Technologies Used

* Java JDK - Version 8
* Maven
* postgreSQL
* Spring Framework
* React
* NodeJS

## Features

List of features ready
* Users can view albums from an artist by searching the artist's name; information provided is the album's name, the album cover, and the release year of the album
* Users can enter new albums into the database

## Getting Started
1. Clone this repository. Use "git clone https://github.com/markanthonyvargas/Music-Directory-App.git" in your terminal to clone this project to a destination on your personal machine.
2. Once this project is cloned you will need to import the BackEnd project into your IDE. In STS you will import an existing Maven project.
3. Since this is a Spring project, once imported, you'll simply need to start the project as a Spring project.
4. The FrontEnd project must be installed using NodeJS. In Visual Studio Code, open a new terminal and make the music-directory-app folder the current directory.
5. Run the "npm install" command inside the terminal to install the React project.
8. This project uses system environment variables in the "application.yl" to connect to a database. These will have to be changed to match your database credentials
9. Once the Spring project is started, head to Visual Studio Code and run the "npm start" command to start your React project.

## Usage

Once the project is ready and the server is running, when the React app is finished starting, the app will open inside your default web browser. Start by adding new albums. Note that the artist field is mandatory for an album to persist. Once an album has been inserted, albums can be viewed by entering an artist's name in the artist search bar and clicking submit.

NOTE: For security purposes this project uses system environment variables for JDBC. You will have to enter your own credentials for your database inside the "application.yml" file.
