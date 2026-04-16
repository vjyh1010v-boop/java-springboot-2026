package com.pknu26.movie_mng.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {

    private Long movieId;           // MOVIE_ID
    private String title;           // TITLE
    private String originalTitle;   // ORIGINAL_TITLE
    private String director;        // DIRECTOR
    private String actors;          // ACTORS
    private String genre;           // GENRE
    private LocalDate releaseDate;  // RELEASE_DATE
    private int runningTime;        // RUNNING_TIME
    private double rating;          // RATING
    private String description;     // DESCRIPTION
    private LocalDateTime createdAt; // CREATED_AT
    private LocalDateTime updatedAt; // UPDATED_AT
}