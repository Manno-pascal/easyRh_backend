package com.manno.easyrh.controllers;


import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.dto.WorkerDTO;
import com.manno.easyrh.entities.Company;
import com.manno.easyrh.services.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@AllArgsConstructor
@RestController
@RequestMapping(path = "company")
public class CompanyController {

    private final CompanyService companyService;

//      Route inutile pour le moment
//      @GetMapping(produces = APPLICATION_JSON_VALUE)
//      public List<CompanyDTO> getCompanies(){
//
//        return this.companyService.getCompaniesDTO();
//    }

//    Route inutile pour le moment
//    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
//    public CompanyDTO getCompanyById(@PathVariable int id) {
//        return this.companyService.getCompanyById(id);
//    }

    @GetMapping(path = "me", produces = APPLICATION_JSON_VALUE)
    public CompanyDTO me() {
        return this.companyService.me();
    }

    @PatchMapping(produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> PatchCompany(@RequestBody CompanyDTO companyDTO) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(Map.of("bearer",this.companyService.patchCompany(companyDTO)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @DeleteMapping()
    public ResponseEntity<Object> DeleteCompany() {
        try {this.companyService.deleteCompany();
            return ResponseEntity.status(HttpStatus.OK).body("The company has been successfully deleted.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }
}
