package com.example.spring_cinema_lab.controllers;

import com.example.spring_cinema_lab.models.Movie;
import com.example.spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        List<Movie> movies = movieService.getAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if(movie.isPresent()){
            return new ResponseEntity<>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Movie> addNewMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.CREATED);
    }



}
