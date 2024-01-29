package com.zmovie.zmovie.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.zmovie.zmovie.model.Review;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {

}