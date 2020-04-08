package com.sv.applaudo.studio.movies.dao;

import com.sv.applaudo.studio.movies.model.Movies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    @Query("SELECT m FROM movies m WHERE m.title LIKE %:title%")
    List<Movies> findByTitleLike(@Param("title") String title);
}
