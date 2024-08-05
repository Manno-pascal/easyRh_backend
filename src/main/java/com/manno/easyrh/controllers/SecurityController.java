package com.manno.easyrh.controllers;

import com.manno.easyrh.dto.AuthenticationDTO;
import com.manno.easyrh.entities.Company;
import com.manno.easyrh.services.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping
public class SecurityController {


    private final SecurityService securityService;

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path = "register", consumes = APPLICATION_JSON_VALUE)
    public Map<String,String> register(@RequestBody Company company) {
        return Map.of("bearer",this.securityService.register(company));
    }

    @PostMapping(path = "login", consumes = APPLICATION_JSON_VALUE)
    public Map<String,String> login(@RequestBody AuthenticationDTO authenticationDTO) {
        return Map.of("bearer",this.securityService.login(authenticationDTO));
    }
}
