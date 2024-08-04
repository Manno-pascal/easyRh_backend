package com.manno.easyrh.controller;

import com.manno.easyrh.entity.Company;

import com.manno.easyrh.service.CompanyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController //On définie ce controller comme étant un controller pour des routes d'api rest
@RequestMapping(path = "company") //On spécifie la route
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {

        this.companyService = companyService;
    }

    @ResponseStatus(value = HttpStatus.CREATED) //On spécifie les codes retournés
    @PostMapping(consumes = APPLICATION_JSON_VALUE) //On spécifie le format des données attendues (application/json)
    public void create(@RequestBody Company company) {
        this.companyService.create(company);
    }

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Company> getCompanies(){
        return this.companyService.getCompanies();
    }

    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public Company getCompanyById(@PathVariable int id){
        return this.companyService.getCompanyById(id);
    }
}
