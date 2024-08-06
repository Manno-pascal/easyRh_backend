package com.manno.easyrh.services;

import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.entities.Company;
import com.manno.easyrh.mappers.CompanyMapper;
import com.manno.easyrh.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@RequiredArgsConstructor
@Service
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;


    public List<CompanyDTO> getCompaniesDTO(){
        return this.companyRepository.findAll().stream().map(companyMapper::toDto).collect(Collectors.toList());
    }

    public CompanyDTO getCompanyById(int id){
        Optional<Company> company = this.companyRepository.findById(id);
        return company.map(companyMapper::toDto).orElse(null);
    }

    public CompanyDTO me() {
        String companyEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return companyMapper.toDto(this.companyRepository.findByEmail(companyEmail));
    }


}
