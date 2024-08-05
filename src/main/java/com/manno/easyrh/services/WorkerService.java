package com.manno.easyrh.services;


import com.manno.easyrh.entities.Company;
import com.manno.easyrh.entities.Worker;
import com.manno.easyrh.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final CompanyService companyService;


    public Worker create(Worker worker) {
        if (this.workerRepository.findByEmail(worker.getEmail()) == null) {
            worker.setCompany(companyService.me());
            this.workerRepository.save(worker);
            return worker;
        }
        return null;
    }

    public boolean delete(int id) {
        Company company = companyService.me();
        Optional<Worker> optionnalWorker = workerRepository.findById(id);
        if (optionnalWorker == null) {
            return false;
        }
        if (company.getId() == optionnalWorker.get().getCompany().getId()) {
            this.workerRepository.delete(optionnalWorker.get());
            return true;
        }
        return false;
    }

    public List<Worker> getWorkersByCompany() {
        return this.workerRepository.findAllByCompany(companyService.me());
    }

    public Worker getWorkerById(int id) {
        Company company = companyService.me();
        Optional<Worker> optionnalWorker = workerRepository.findById(id);
        if (optionnalWorker == null) {
            return null;
        }
        if (company.getId() == optionnalWorker.get().getCompany().getId()) {
            return this.workerRepository.findById(id).orElse(null);
        }
        return null;
    }

    public Worker patchWorker(int id, Map<String, Object> updates) {
        Company company = companyService.me();
        Optional<Worker> optionnalWorker = workerRepository.findById(id);
        if (optionnalWorker == null) {
            return null;
        }
        Worker worker = optionnalWorker.get();
        if (company.getId() == worker.getCompany().getId()) {
            log.info(updates.toString());
            for (Map.Entry<String, Object> entry : updates.entrySet()) {

//                if (worker.getClass().getDeclaredField(entry.getKey()){
//
//                }
                String key = entry.getKey();
                Object value = entry.getValue();
                log.info("Key: " + key + ", Value: " + value);
            }

            return this.workerRepository.findById(id).orElse(null);
        }
        return null;
    }
}
