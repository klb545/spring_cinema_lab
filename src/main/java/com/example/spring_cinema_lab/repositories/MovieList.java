package com.example.spring_cinema_lab.repositories;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Repository
public class MovieList {

    private List<String> movies;

    public MovieList(){
        this.movies = Arrays.asList(
                "Spiderman",
                "Batman",
                "Cinderella",
                "Beauty and the Beast",
                "Harry Potter and the Philosopher's Stone",
                "Harry Potter and the Chamber of Secrets",
                "Harry Potter and the Order of the Phoenix"
        );
    }

//    public String getMovieById(){
//        Random random = new Random();
//        int randomIndex = random.nextInt(this.words.size());
//        return this.words.get(randomIndex);
//    }

}
