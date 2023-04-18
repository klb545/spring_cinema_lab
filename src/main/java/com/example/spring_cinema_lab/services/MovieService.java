package com.example.spring_cinema_lab.services;

import com.example.spring_cinema_lab.models.Movie;
import com.example.spring_cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;


    public MovieService() {
        //
    }

// methods

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }


    public Optional<Movie> getMovieById(int id){
        return movieRepository.findById(id);
    }



//      EXTENSIONS
//    update a movie in the database
    public void updateMovie(int id, String newTitle, int newRating, int newDuration){
        Movie movieLocatedById = movieRepository.findById(id).get();
        movieLocatedById.setTitle(newTitle);
        movieLocatedById.setRating(newRating);
        movieLocatedById.setDuration(newDuration);
        movieRepository.save(movieLocatedById);
    }
//    delete a movie from the database
    public void deleteMovie(int id){
        Movie movieLocatedById = movieRepository.findById(id).get();
        movieRepository.delete(movieLocatedById);
    }

}
