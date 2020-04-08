package com.sv.applaudo.studio.movies.service;

import com.sv.applaudo.studio.movies.dao.MoviesRepository;
import com.sv.applaudo.studio.movies.dao.RentalRepository;
import com.sv.applaudo.studio.movies.model.Movies;
import com.sv.applaudo.studio.movies.model.Rental;
import com.sv.applaudo.studio.movies.service.RentMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RentMovieServiceImpl implements RentMovieService {

    @Autowired
    RentalRepository rentalRepository;

    /**
     * Add a new rental
     * @param rental
     * @return
     */
    public Rental addRental(Rental rental){
        return rentalRepository.save(rental);
    }

    /**
     * Update a new rental
     * @param rental
     * @return
     */
//    public Rental updateRental(Rental rental){
//        return rentalRepository.save(rental);
//    }

    /**
     * Return all rentals
     * @return
     */
//    public List<Rental> allRentals(){
//        List<Rental> rental=new ArrayList<>();
//        for (Rental meeting:rentalRepository.findAll()) {
//            rental.add(meeting);
//        }
//        return rental;
//    }

    /**
     * delete a rental
     * @param id
     * @return
     */
//    public void deleteRental(Integer id){
//        rentalRepository.deleteById(id);
//    }
}
