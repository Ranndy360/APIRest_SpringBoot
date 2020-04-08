package com.sv.applaudo.studio.movies.controller;

import com.sv.applaudo.studio.movies.exception.EntityNotFoundException;
import com.sv.applaudo.studio.movies.helper.BaseRestController;
import com.sv.applaudo.studio.movies.model.Movies;
import com.sv.applaudo.studio.movies.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * endpoints for movies CRUD
 */
@RestController
@RequestMapping
public class MoviesController extends BaseRestController {

    @Autowired
    private MoviesService moviesService;

    /**
     * Add a new movie endpoint
     * @param movie
     * @return
     */
    @PostMapping(value = "movies", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> addMovie(@RequestBody Movies movie) {
        return generateResponseOk(moviesService.addMovie(movie));
    }

    /**
     * Update a movie
     * @param movie
     * @return
     */
    @PutMapping(value = "movies", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> updateMovie(@RequestBody Movies movie) {
        return generateResponseOk(moviesService.updateMovie(movie));
    }

    /**
     * Return all data
     * @return
     */
    @GetMapping(value = "movies", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> allMovies() {
        return generateResponseOk(moviesService.allMovies());
    }

    /**
     * Delete a specific movie
     * @param id
     * @return
     */
    @DeleteMapping(value = "movies/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('ADM')")
    public ResponseEntity<?> deleteMovies(@PathVariable(name = "id") int id) {
        moviesService.deleteMovie(id);
        Map<String, Object> hasmap = new HashMap<String, Object>();
        hasmap.put("status",true);
        hasmap.put("message","Movie deleted successfully");
        return generateResponseOk(hasmap);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleEntityNotFoundException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleException(EntityNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
