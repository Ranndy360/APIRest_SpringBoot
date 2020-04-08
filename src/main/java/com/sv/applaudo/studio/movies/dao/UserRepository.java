package com.sv.applaudo.studio.movies.dao;

import com.sv.applaudo.studio.movies.model.Users;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository  extends CrudRepository<Users, Integer> {

    Optional<Users> findOneByMail(String mail);
}
