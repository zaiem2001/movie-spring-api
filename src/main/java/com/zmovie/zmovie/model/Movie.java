package com.zmovie.zmovie.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "movies")
@Data
@NoArgsConstructor
public class Movie {

    @Id
    private ObjectId id;

    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;

    private List<String> genres;

    private String poster;
    private List<String> backdrops;

    @DocumentReference
    private List<Review> reviewIds;

}
