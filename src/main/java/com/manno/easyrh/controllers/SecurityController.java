package com.manno.easyrh.controllers;

import com.manno.easyrh.dto.AuthenticationDTO;
import com.manno.easyrh.entities.Company;
import com.manno.easyrh.services.SecurityService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping
public class SecurityController {

    private AuthenticationManager authenticationManager;
    private final SecurityService securityService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path="register", consumes = APPLICATION_JSON_VALUE)
    public void register(@RequestBody Company company) {
        this.securityService.register(company);
    }

    @PostMapping(path = "login", consumes = APPLICATION_JSON_VALUE)
    public Map<String,String> login(@RequestBody AuthenticationDTO authenticationDTO) {
        log.info("Login attempt");
        log.info(authenticationDTO.toString());
        try {

            final Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationDTO.username(),
                            authenticationDTO.password()
                    )
            );
            log.info("chelou {}", authenticate.isAuthenticated());
        } catch (AuthenticationException e) {
            log.info(e.getMessage());
        }
        return null;
    }
}
