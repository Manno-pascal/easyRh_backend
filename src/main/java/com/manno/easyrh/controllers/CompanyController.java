package com.manno.easyrh.controllers;


import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.dto.WorkerDTO;
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
    public List<CompanyDTO> getCompanies(){return this.companyService.getCompaniesDTO();}

    @GetMapping(path="{id}", produces = APPLICATION_JSON_VALUE)
    public CompanyDTO getCompanyById(@PathVariable int id){
        return this.companyService.getCompanyById(id);
    }

    @GetMapping(path = "me", produces = APPLICATION_JSON_VALUE)
    public CompanyDTO me() {return this.companyService.me();}

    @PatchMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public CompanyDTO PatchCompany(@RequestBody CompanyDTO companyDTO) {return this.companyService.patchCompany(companyDTO);}

    @DeleteMapping()
    public void DeleteCompany() {this.companyService.deleteCompany();}
}
