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
}
