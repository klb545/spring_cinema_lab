package com.example.spring_cinema_lab.models;

import jakarta.persistence.*;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;
    @Column(name = "rating")
    private int rating;
    @Column(name = "duration")
    private int duration;

//    constructor
    public Movie(String title){
        this.title = title;
        this.rating = rating;
        this.duration = duration;
    }

//    default constructor
    public Movie(){
        //
    }

//getter & setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
