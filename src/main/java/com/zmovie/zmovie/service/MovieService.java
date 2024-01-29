package com.zmovie.zmovie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zmovie.zmovie.model.Movie;
import com.zmovie.zmovie.repository.MovieRepository;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findByImdbId(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

}
