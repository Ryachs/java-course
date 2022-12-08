package com.rchf.movie.app.services.impl;

import com.rchf.movie.app.controllers.MoviesController;
import com.rchf.movie.app.entities.Movie;
import com.rchf.movie.app.mapper.MoviesMapper;
import com.rchf.movie.app.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    protected static Logger logger = (Logger) LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MoviesMapper moviesMapper;
    @Override
    public List<Movie> findMovies() {
        logger.info("Servicio findMovies [{}]");
        return moviesMapper.findMovies();
    }

    @Override
    public Movie findById(long id) {
        logger.info("Servicio findMovies [{}]", id);
        Movie movie = moviesMapper.findById(id);
        logger.info("Servicio findByName [{}]", movie);
        return movie;
    }

    @Override
    public void dropById(long id) {
        logger.info("Servicio dropById [{}]");
        moviesMapper.dropById(id);
    }

    @Override
    public void updateMovie(Movie movie) {
        logger.info("Servicio updateMovie [{}]");
        moviesMapper.updateMovie(movie);
    }

    @Override
    public void publishMovie(Movie movie) {
        logger.info("Servicio publishMovie [{}]");
        moviesMapper.publishMovie(movie);
    }
}
