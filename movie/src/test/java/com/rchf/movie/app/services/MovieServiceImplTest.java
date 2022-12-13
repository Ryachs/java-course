package com.rchf.movie.app.services;

import com.rchf.movie.app.Datos;
import com.rchf.movie.app.entities.Movie;
import com.rchf.movie.app.mapper.MoviesMapper;
import com.rchf.movie.app.services.impl.MovieServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class MovieServiceImplTest {

    @InjectMocks
    private MovieServiceImpl movieService;

    @Mock
    private MoviesMapper moviesMapper;

    @Test
    public void testfindMovies() {
        Mockito.when(moviesMapper.findMovies()).thenReturn(Datos.MOVIES);
        List<Movie> movie = movieService.findMovies();

        assertEquals(3L, movie.size());
        Mockito.verify(moviesMapper).findMovies();
    }

    @Test
    public void testfindById() {
        Mockito.when(moviesMapper.findById(1L)).thenReturn(Datos.MOVIES_ID);
        Movie movie = movieService.findById(1L);

        assertNotNull(movie);
    }
}
