package com.manno.easyrh.services;

import com.manno.easyrh.entities.Company;
import com.manno.easyrh.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getCompanies(){
        return this.companyRepository.findAll();
    }

    public Company getCompanyById(int id){
        Optional<Company> company = this.companyRepository.findById(id);
        return company.orElse(null);
    }

    public Company me() {
        String companyEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.companyRepository.findByEmail(companyEmail) ;
    }
}
