package com.manno.easyrh.services;

import com.manno.easyrh.dto.AuthenticationDTO;
import com.manno.easyrh.dto.CompanyDTO;
import com.manno.easyrh.entities.Company;
import com.manno.easyrh.mappers.CompanyMapper;
import com.manno.easyrh.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        if (this.companyRepository.findByEmail(companyDto.getEmail()) != null)
            throw new RuntimeException("Email déjà utilisé");
        AuthenticationDTO authenticationDTO = new AuthenticationDTO(companyDto.getEmail(), companyDto.getPassword());
        this.companyRepository.save(companyMapper.toEntity(companyDto));
        //J'ai un doute ici, je crée une instance d'authentication avant d'avoir save l'utilisateur en bdd
        return this.login(authenticationDTO);
    }

    public String login(AuthenticationDTO authenticationDTO) {
            final Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authenticationDTO.username(),
                            authenticationDTO.password()
                    )
            );
            if (authenticate.isAuthenticated()) {
                return this.jwtService.generateToken(authenticationDTO.username());
            }
        return null;
    }


    public Company getCompanySession() {
        String companyEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.companyRepository.findByEmail(companyEmail);
    }



}
