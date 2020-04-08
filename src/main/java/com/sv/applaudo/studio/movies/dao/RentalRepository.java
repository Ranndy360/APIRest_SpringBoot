package com.sv.applaudo.studio.movies.dao;

import com.sv.applaudo.studio.movies.model.Rental;
import org.springframework.data.repository.CrudRepository;

public interface RentalRepository extends CrudRepository<Rental, Integer> {
}
