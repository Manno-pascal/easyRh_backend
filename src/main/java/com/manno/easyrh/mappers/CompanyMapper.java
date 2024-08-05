package com.manno.easyrh.mappers;


import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.entities.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CompanyMapper {
    private final BCryptPasswordEncoder passwordEncoder;

    public CompanyDTO toDto(Company company) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setEmail(company.getEmail());
        dto.setCity(company.getCity());
        dto.setAddress(company.getAddress());
        dto.setPhoneNumber(company.getPhoneNumber());
        dto.setCeoFirstname(company.getCeoFirstname());
        dto.setCeoLastname(company.getCeoLastname());
        dto.setContactLastname(company.getContactLastname());
        dto.setContactFirstname(company.getContactFirstname());
        dto.setDomain(company.getDomain());
        dto.setCompanyName(company.getCompanyName());
        return dto;
    }

    public Company toEntity(CompanyDTO dto, Company company) {
        if (dto.getEmail() != null) {
            company.setEmail(dto.getEmail());
        }
        if (dto.getCity() != null) {
            company.setCity(dto.getCity());
        }
        if (dto.getAddress() != null) {
            company.setAddress(dto.getAddress());
        }
        if (dto.getPhoneNumber() != null) {
            company.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getCeoFirstname() != null) {
            company.setCeoFirstname(dto.getCeoFirstname());
        }
        if (dto.getCeoLastname() != null) {
            company.setCeoLastname(dto.getCeoLastname());
        }
        if (dto.getContactLastname() != null) {
            company.setContactLastname(dto.getContactLastname());
        }
        if (dto.getContactFirstname() != null) {
            company.setContactFirstname(dto.getContactFirstname());
        }
        if (dto.getDomain() != null) {
            company.setDomain(dto.getDomain());
        }
        if (dto.getCompanyName() != null) {
            company.setCompanyName(dto.getCompanyName());
        }
        if (dto.getPassword() != null) {
            company.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return company;
    }

    public Company toEntity(CompanyDTO dto) {
        Company company = new Company();
        company.setEmail(dto.getEmail());
        company.setCity(dto.getCity());
        company.setAddress(dto.getAddress());
        company.setPhoneNumber(dto.getPhoneNumber());
        company.setCeoFirstname(dto.getCeoFirstname());
        company.setCeoLastname(dto.getCeoLastname());
        company.setContactLastname(dto.getContactLastname());
        company.setContactFirstname(dto.getContactFirstname());
        company.setDomain(dto.getDomain());
        company.setCompanyName(dto.getCompanyName());
        company.setPassword(passwordEncoder.encode(dto.getPassword()));
        return company;
    }
}
