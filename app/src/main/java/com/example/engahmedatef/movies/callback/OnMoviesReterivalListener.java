package com.example.engahmedatef.movies.callback;

import com.example.engahmedatef.movies.model.Movie;

import java.util.List;

public interface OnMoviesReterivalListener {

    void onSucess(List<Movie> movieList);

    void onError(String errorMsg);
}
