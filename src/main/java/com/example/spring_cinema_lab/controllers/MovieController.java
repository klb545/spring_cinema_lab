package com.example.spring_cinema_lab.controllers;

import com.example.spring_cinema_lab.models.Movie;
import com.example.spring_cinema_lab.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

////    MVP version of the getAllMovies() method. Replaced with advanced extension beginning line 68.
//    @GetMapping
//    public ResponseEntity<List<Movie>> getAllMovies(){
//        List<Movie> movies = movieService.getAllMovies();
//        return new ResponseEntity<>(movies, HttpStatus.OK);
//    }

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

//    EXTENSIONS
//    update movie in the database
    @PutMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable int id, @RequestParam(value = "title") String title, @RequestParam(value = "rating") int rating, @RequestParam(value = "duration") int duration) {
        if(movieService.getMovieById(id).isPresent()) {
            movieService.updateMovie(id, title, rating, duration);
            return new ResponseEntity<>(movieService.getMovieById(id).get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

//    delete movie from the database
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable int id) {
        if(movieService.getMovieById(id).isPresent()) {
            movieService.deleteMovie(id);
            return new ResponseEntity<>("Movie with id of " + id + "deleted.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }


//      ADVANCED EXTENSION
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) Integer maxDuration){

        List<Movie> movies = movieService.getAllMovies();
        if (maxDuration == null){
            return new ResponseEntity<>(movies, HttpStatus.OK);
        }

        List<Movie> moviesFilteredByDuration = new ArrayList<>();
        for(int i = 0; i < movies.size(); i++) {
            if(movies.get(i).getDuration() <= maxDuration.intValue()) {
                moviesFilteredByDuration.add(movies.get(i));
            }
        }
        return new ResponseEntity<>(moviesFilteredByDuration, HttpStatus.OK);

    }



}
