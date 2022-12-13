package com.rchf.movie.app;

import com.rchf.movie.app.entities.Movie;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Datos {
    public final static List<Movie> MOVIES = Arrays.asList(new Movie(1L, "Black Adam",
                    "Jaume Collet-Serra", Date.valueOf("2022-09-09")),
            new Movie(2L, "Ant-Man and the Wasp: Quantumania", "Peyton Reed", Date.valueOf("2023-03-04")),
            new Movie(3L, "Wakanda Forever", "John Papsidera", Date.valueOf("2022-02-02")));

    public final static Movie MOVIES_ID = new Movie(1L, "Black Adam",
                    "Jaume Collet-Serra", Date.valueOf("2022-09-09"));
}
