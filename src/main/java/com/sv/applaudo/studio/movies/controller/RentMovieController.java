package com.sv.applaudo.studio.movies.controller;

import com.sv.applaudo.studio.movies.helper.BaseRestController;
import com.sv.applaudo.studio.movies.helper.Helper;
import com.sv.applaudo.studio.movies.model.Rental;
import com.sv.applaudo.studio.movies.service.MoviesService;
import com.sv.applaudo.studio.movies.service.RentMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping(value = "rent")
public class RentMovieController extends BaseRestController {

    @Autowired
    private MoviesService moviesService;

    @Autowired
    private RentMovieService rentMovieService;

    @Autowired
    private Helper helper;


    @GetMapping(value = {"movies/{title}","movies"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
//    @PreAuthorize("hasRole('BUY')")
    public ResponseEntity<?> allMovies(@PathVariable(required = false) String title) {
        if(title==null)
            return generateResponseOk(moviesService.allMovies());
        else
            return generateResponseOk(moviesService.allMovies(title));
    }

    @PostMapping(value = {"movies"}, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @PreAuthorize("hasRole('BUY')")
    public ResponseEntity<?> rentMovies(Rental rental) {

        if(rental.getState().equals("RENT")) {
            rental = helper.setDates(rental);
        }

        return generateResponseOk(rentMovieService.addRental(rental));
    }

}
