package com.manno.easyrh.repository;


import com.manno.easyrh.model.Company;
import com.manno.easyrh.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker findByEmail(String email);
    List<Worker> findAllByCompany(Company company);
}
