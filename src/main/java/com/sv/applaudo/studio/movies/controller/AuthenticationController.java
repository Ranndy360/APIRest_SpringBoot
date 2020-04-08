package com.sv.applaudo.studio.movies.controller;


import com.sv.applaudo.studio.movies.beans.AuthToken;
import com.sv.applaudo.studio.movies.beans.AuthenticationBean;
import com.sv.applaudo.studio.movies.config.TokenProvider;
import com.sv.applaudo.studio.movies.helper.BaseRestController;
import com.sv.applaudo.studio.movies.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


/**
 * Validate credencials
 */

@RestController
@RequestMapping
public class AuthenticationController extends BaseRestController{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenProvider jwtTokenUtil;

    /**
     * @param request
     * @return
     */
    @PostMapping(value = "/login")
    @ResponseBody
    public ResponseEntity<?> login(@RequestBody AuthenticationBean request) {

        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getMail(),
                        request.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);


        final String token = jwtTokenUtil.generateToken(authentication);
        return ResponseEntity.ok(new AuthToken(token));
    }

}
