package com.manno.easyrh.repository;

import com.manno.easyrh.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Integer> /* permet de récupérer les méthode de base d'un repository*/ {
    Company findByEmail(String email);
}
