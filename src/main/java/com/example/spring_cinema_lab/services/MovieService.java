package com.example.spring_cinema_lab.services;

import com.example.spring_cinema_lab.models.Movie;
import com.example.spring_cinema_lab.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

//other methods
//    public void addMovie(Movie movie){
//        listOfMovies.add(movie);
//    }
    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }


    public Optional<Movie> getMovieById(int id){
        return movieRepository.findById(id);
    }


//    getters and setters




}
