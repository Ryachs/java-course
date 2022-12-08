package com.rchf.movie.app.controllers;

import com.rchf.movie.app.entities.Movie;
import com.rchf.movie.app.services.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dal/v1")
public class MoviesController {

    protected static Logger logger = (Logger) LoggerFactory.getLogger(MoviesController.class);

    @Autowired
    private MovieService movieService;

    @GetMapping(path = "/search")
    public List<Movie>findMovies() {
        logger.info("Metodo findMovies: [{}]");
        List<Movie> movies = movieService.findMovies();
        logger.info("Return findMovies: [{}]", movies);
        return movies;
    }

    @GetMapping(path = "/search/id/{id}")
    public ResponseEntity<Movie>findById(@PathVariable("id") long id) {
        logger.info("Metodo findByName: [{}]", id);
        try {
            Movie movie = movieService.findById(id);
            logger.info("Return findByName: [{}]", movie);
            return ResponseEntity.ok(movie);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Void>dropById(@PathVariable("id") long id) {
        logger.info("Metodo dropById: [{}]", id);
        movieService.dropById(id);
        logger.info("Return dropById");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(path = "/update")
    public ResponseEntity<Void>updateMovie(@Valid @RequestBody Movie movie) {
        logger.info("Metodo updateMovie: [{}]", movie);
        movieService.updateMovie(movie);
        logger.info("Return updateMovie: [{}]");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(path = "/insert")
    public ResponseEntity<Void>publishMovie(@Valid @RequestBody Movie movie) {
        logger.info("Metodo publishMovie: [{}]", movie);
        movieService.publishMovie(movie);
        logger.info("Return publishMovie: [{}]");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
