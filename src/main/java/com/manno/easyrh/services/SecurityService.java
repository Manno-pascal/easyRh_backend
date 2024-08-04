package com.manno.easyrh.services;

import com.manno.easyrh.entities.Company;
import com.manno.easyrh.repositories.CompanyRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class SecurityService implements UserDetailsService {

    private BCryptPasswordEncoder passwordEncoder;
    private CompanyRepository companyRepository;

    public void register(Company company){
        if (this.companyRepository.findByEmail(company.getEmail()) != null) throw new RuntimeException("Email déjà utilisé");
        company.setPassword(passwordEncoder.encode(company.getPassword()));
        this.companyRepository.save(company);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) this.companyRepository.findByEmail(username);
    }
}
