package com.sv.applaudo.studio.movies.service;

import com.sv.applaudo.studio.movies.model.Movies;

import java.util.List;


public interface MoviesService {

    Movies addMovie(Movies movie);
    Movies updateMovie(Movies movie);
    List<Movies> allMovies();
    List<Movies> allMovies(String title);
    void deleteMovie(Integer id);
}
