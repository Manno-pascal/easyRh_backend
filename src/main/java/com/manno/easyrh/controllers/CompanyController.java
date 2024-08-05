package com.manno.easyrh.controllers;

import com.manno.easyrh.dto.AuthenticationDTO;
import com.manno.easyrh.entities.Company;

import com.manno.easyrh.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "company")
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Company> getCompanies(){return this.companyService.getCompanies();}

    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Company getCompanyById(@PathVariable int id){
        return this.companyService.getCompanyById(id);
    }

    @GetMapping(path = "me", produces = APPLICATION_JSON_VALUE)
    public Company me() {return this.companyService.me();}
}
