package com.manno.easyrh.controllers;

import com.manno.easyrh.dto.AuthenticationDTO;
import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.services.SecurityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping
public class SecurityController {


    private final SecurityService securityService;

    @PostMapping(path = "register", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> register(@RequestBody CompanyDTO companyDTO) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("bearer",this.securityService.register(companyDTO)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping(path = "login", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> login(@RequestBody AuthenticationDTO authenticationDTO) {
        try {
            return ResponseEntity.ok(Map.of("bearer",this.securityService.login(authenticationDTO)));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
