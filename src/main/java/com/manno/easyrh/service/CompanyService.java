package com.manno.easyrh.service;

import com.manno.easyrh.entity.Company;
import com.manno.easyrh.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class CompanyService {

    private CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {

        this.companyRepository = companyRepository;
    }

    public void create(Company company){
        this.companyRepository.save(company);
    }
}
