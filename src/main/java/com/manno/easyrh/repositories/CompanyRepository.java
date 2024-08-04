package com.manno.easyrh.repositories;

import com.manno.easyrh.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CompanyRepository extends JpaRepository<Company, Integer> /* permet de récupérer les méthode de base d'un repository*/ {

    Company findByEmail(String email);

}
