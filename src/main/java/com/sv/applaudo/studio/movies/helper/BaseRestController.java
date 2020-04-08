package com.sv.applaudo.studio.movies.helper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BaseRestController {

    public ResponseEntity<?> generateResponseOk(Object object){
        return new ResponseEntity<>(object, HttpStatus.OK);
    }
}
