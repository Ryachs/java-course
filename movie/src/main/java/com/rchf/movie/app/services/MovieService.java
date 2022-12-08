package com.rchf.movie.app.services;

import com.rchf.movie.app.entities.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> findMovies();
    public Movie findById(long id);
    public void dropById(long id);
    public void updateMovie(Movie movie);
    public void publishMovie(Movie movie);
}
