package com.manno.easyrh.service;

import com.manno.easyrh.dto.AuthenticationDTO;
import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.model.Company;
import com.manno.easyrh.mapper.CompanyMapper;
import com.manno.easyrh.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityService {

    private final CompanyRepository companyRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CompanyMapper companyMapper;


    public String register(CompanyDTO companyDto) {
        if (this.companyRepository.findByEmail(companyDto.getEmail()) != null) {
            throw new RuntimeException("Email is already registered.");
        }
        try {
            AuthenticationDTO authenticationDTO = new AuthenticationDTO(companyDto.getEmail(), companyDto.getPassword());
            this.companyRepository.save(companyMapper.toEntity(companyDto));
            return this.login(authenticationDTO);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating the company.");
        }
    }

    public String login(AuthenticationDTO authenticationDTO) {
        try {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationDTO.getUsername(),
                            authenticationDTO.getPassword()
                    )
            );
            if (authenticate.isAuthenticated()) {
                return jwtService.generateToken(authenticationDTO.getUsername());
            }
            throw new RuntimeException("Invalid email or password");
        } catch (Exception e) {
            throw new RuntimeException("Invalid email or password");
        }
    }


    public Company getCompanySession() {
        String companyEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.companyRepository.findByEmail(companyEmail);
    }


}
