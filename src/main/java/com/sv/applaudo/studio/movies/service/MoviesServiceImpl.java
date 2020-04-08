package com.sv.applaudo.studio.movies.service;

import com.sv.applaudo.studio.movies.dao.MoviesRepository;
import com.sv.applaudo.studio.movies.model.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * movies CRUD service provider
 */
@Service
@Transactional
public class MoviesServiceImpl implements MoviesService{

    @Autowired
    MoviesRepository moviesRepository;

    /**
     * Add a new movie
     * @param movie
     * @return
     */
    public Movies addMovie(Movies movie){
        return moviesRepository.save(movie);
    }

    /**
     * Update a new movie
     * @param movie
     * @return
     */
    public Movies updateMovie(Movies movie){
        return moviesRepository.save(movie);
    }

    /**
     * Return all movies
     * @return
     */
    public List<Movies> allMovies(){
        List<Movies> movie=new ArrayList<>();
        for (Movies meeting:moviesRepository.findAll()) {
            movie.add(meeting);
        }
        return movie;
    }

    /**
     * Return all movies filtered by title
     * @param title
     * @return
     */
    public List<Movies> allMovies(String title){
        List<Movies> movie=new ArrayList<>();
        for (Movies meeting:moviesRepository.findByTitleLike(title)) {
            movie.add(meeting);
        }
        return movie;
    }

    /**
     * delete a movie
     * @param id
     * @return
     */
    public void deleteMovie(Integer id){
        moviesRepository.deleteById(id);
    }

}
