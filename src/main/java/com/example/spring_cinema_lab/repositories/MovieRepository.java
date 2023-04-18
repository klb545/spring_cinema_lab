package com.example.spring_cinema_lab.repositories;

import com.example.spring_cinema_lab.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
