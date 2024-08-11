package com.manno.easyrh.services;

import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.entities.Company;
import com.manno.easyrh.mappers.CompanyMapper;
import com.manno.easyrh.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    private final SecurityService securityService;

    public List<CompanyDTO> getCompaniesDTO(){
        return this.companyRepository.findAll().stream().map(companyMapper::toDto).collect(Collectors.toList());
    }

    public CompanyDTO getCompanyById(int id){
        Optional<Company> company = this.companyRepository.findById(id);
        return company.map(companyMapper::toDto).orElse(null);
    }

    public CompanyDTO me() {
        return companyMapper.toDto(this.securityService.getCompanySession());
    }

    public CompanyDTO patchCompany(CompanyDTO updates) {
        try {
            Company modifiedCompany = companyMapper.toEntity(updates,securityService.getCompanySession());
            return companyMapper.toDto(companyRepository.save(modifiedCompany));
        }catch (Exception e){
            throw new RuntimeException("Error while editing the company.");
        }

    }

    public void deleteCompany() {
        try {
            companyRepository.delete(securityService.getCompanySession());
        }catch (Exception e){
            throw new RuntimeException("Error while deleting the company.");
        }

    }
}
