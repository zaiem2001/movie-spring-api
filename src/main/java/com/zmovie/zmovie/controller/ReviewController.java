package com.zmovie.zmovie.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zmovie.zmovie.model.Review;
import com.zmovie.zmovie.service.ReivewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReivewService reivewService;

    @PostMapping("")
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        String reviewBody = payload.get("reviewBody");
        String imdbId = payload.get("imdbId");

        Review review = reivewService.createReview(reviewBody, imdbId);
        return new ResponseEntity<>(review, HttpStatus.CREATED);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<List<Review>> getMovieReviews(@PathVariable String imdbId) {
        return new ResponseEntity<>(reivewService.getMovieReviews(imdbId), HttpStatus.OK);
    }

}
