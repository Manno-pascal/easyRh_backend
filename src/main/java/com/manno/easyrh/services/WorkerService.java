package com.manno.easyrh.services;


import com.manno.easyrh.entities.Worker;
import com.manno.easyrh.repositories.WorkerRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;

    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public void create(Worker worker){
        if (this.workerRepository.findByEmail(worker.getEmail()) == null){
            this.workerRepository.save(worker);
        }

    }
}
