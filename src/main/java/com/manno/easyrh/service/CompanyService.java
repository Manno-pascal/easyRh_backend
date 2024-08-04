package com.manno.easyrh.service;

import com.manno.easyrh.entity.Company;
import com.manno.easyrh.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void create(Company company){
        if (this.companyRepository.findByEmail(company.getEmail()) == null){
            this.companyRepository.save(company);
        }

    }

    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

    public Company getCompanyById(int id){
        Optional<Company> company = this.companyRepository.findById(id);
        return company.orElse(null);
    }

}
