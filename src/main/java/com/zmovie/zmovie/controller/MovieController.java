package com.zmovie.zmovie.controller;

import org.springframework.web.bind.annotation.RestController;

import com.zmovie.zmovie.model.Movie;
import com.zmovie.zmovie.service.MovieService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> theMovies = movieService.findAll();

        return new ResponseEntity<>(theMovies, HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovieOptional(@PathVariable String imdbId) {
        return new ResponseEntity<>(movieService.findByImdbId(imdbId), HttpStatus.OK);
    }

}
