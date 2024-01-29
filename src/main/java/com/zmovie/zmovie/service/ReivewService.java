package com.zmovie.zmovie.service;

import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.zmovie.zmovie.model.Movie;
import com.zmovie.zmovie.model.Review;
import com.zmovie.zmovie.repository.ReviewRepository;

@Service
public class ReivewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = new Review(reviewBody);

        reviewRepository.insert(review);

        Query query = new Query(Criteria.where("imdbId").is(imdbId));
        Update update = new Update().push("reviewIds", review);
        mongoTemplate.updateFirst(query, update, Movie.class);

        return review;
    }

    public List<Review> getMovieReviews(String imdbId) {
        Query query = new Query(Criteria.where("imdbId").is(imdbId));
        Movie movie = mongoTemplate.findOne(query, Movie.class);

        if (movie != null) {
            List<Review> reviewList = movie.getReviewIds();
            List<ObjectId> reviewIds = new ArrayList<>();

            for (Review review : reviewList) {
                reviewIds.add(review.getId());
            }

            Query rQuery = new Query(Criteria.where("id").in(reviewIds));

            return mongoTemplate.find(rQuery, Review.class);

        }

        return List.of();

    }

}
