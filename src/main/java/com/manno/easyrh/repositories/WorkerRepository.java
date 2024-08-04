package com.manno.easyrh.repositories;


import com.manno.easyrh.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {
    Worker findByEmail(String email);
}
