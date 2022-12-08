package com.rchf.movie.app.mapper;

import com.rchf.movie.app.entities.Movie;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MoviesMapper {
    @Results(id = "Movie", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name_movie"),
            @Result(property = "director", column = "director_movie"),
            @Result(property = "year", column = "year_movie")
    })
    @Select("SELECT id, name_movie, director_movie, year_movie FROM movies")
    List<Movie> findMovies();

    @Select("SELECT id, name_movie, director_movie, year_movie FROM movies WHERE id = #{id}")
    Movie findById(@Param("id") long id);

    @Delete("DELETE FROM movies WHERE id = #{id}")
    void dropById(@Param("id") long id);

    @Update("UPDATE movies SET name_movie = #{name}, director_movie = #{director}, year_movie = #{year} WHERE id = #{id}")
    void updateMovie(Movie movie);

    @Insert("INSERT INTO movies(name_movie, director_movie, year_movie)VALUES(#{name}, #{director}, #{year})")
    void publishMovie(Movie movie);

}
