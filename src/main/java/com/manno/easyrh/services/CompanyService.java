package com.manno.easyrh.services;

import com.manno.easyrh.entities.Company;
import com.manno.easyrh.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

    public Company getCompanyById(int id){
        Optional<Company> company = this.companyRepository.findById(id);
        return company.orElse(null);
    }
}
