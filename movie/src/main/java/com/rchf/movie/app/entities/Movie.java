package com.rchf.movie.app.entities;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class Movie {
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String director;
    private Date year;

    public Movie(long id, String name, String director, Date year) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.year = year;

    }
}
