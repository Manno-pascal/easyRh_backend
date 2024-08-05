package com.manno.easyrh.repositories;


import com.manno.easyrh.entities.Company;
import com.manno.easyrh.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker findByEmail(String email);
    List<Worker> findAllByCompany(Company company);
}
