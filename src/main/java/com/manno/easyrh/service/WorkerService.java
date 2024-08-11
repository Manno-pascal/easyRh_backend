package com.manno.easyrh.service;


import com.manno.easyrh.dto.WorkerDTO;
import com.manno.easyrh.model.Company;
import com.manno.easyrh.model.Worker;
import com.manno.easyrh.mapper.WorkerMapper;
import com.manno.easyrh.repository.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final CompanyService companyService;
    private final WorkerMapper workerMapper;
    private final SecurityService securityService;


    public WorkerDTO create(WorkerDTO workerDTO) {
        if (this.workerRepository.findByEmail(workerDTO.getEmail()) == null) {
            workerDTO.setCompany(companyService.me());
            Worker worker = workerMapper.toEntity(workerDTO);
            return workerMapper.toDto(this.workerRepository.save(worker));
        }
        throw new RuntimeException("Email is already registered.");
    }

    public void delete(int id) {
        Company company = securityService.getCompanySession();
        Worker worker = workerRepository.findById(id).orElse(null);
        if (worker == null) {
            throw new RuntimeException("No worker associated with this company could be found with this ID.");
        }
        if (company.getId() == worker.getCompany().getId()) {
            this.workerRepository.delete(worker);
        }
        throw new RuntimeException("Error while deleting the worker.");
    }

    public List<WorkerDTO> getWorkersByCompany() {
        List<WorkerDTO> workerDTOs = this.workerRepository.findAllByCompany(securityService.getCompanySession()).stream().map(workerMapper::toDto).toList();
        if (workerDTOs.isEmpty()) {
            throw new RuntimeException("No employee found in the company.");
        }
        return workerDTOs;
    }

    public WorkerDTO getWorkerById(int id) {
        Company company = securityService.getCompanySession();
        Worker worker = workerRepository.findById(id).orElse(null);
        if (worker == null) {
            throw new RuntimeException("No worker associated with this company could be found with this ID.");
        }
        if (company.getId() == worker.getCompany().getId()) {
            return this.workerMapper.toDto(worker);

        }
        throw new RuntimeException("No worker associated with this company could be found with this ID.");

    }

    public WorkerDTO patchWorker(int id, WorkerDTO updates) {
        Company company = securityService.getCompanySession();
        Worker worker = workerRepository.findById(id).orElse(null);
        if (worker == null) {
            throw new RuntimeException("No worker associated with this company could be found with this ID.");
        }
        if (company.getId() == worker.getCompany().getId()) {
            Worker modifiedWorker = workerMapper.toEntity(updates, worker);
            return workerMapper.toDto(workerRepository.save(modifiedWorker));
        }
        throw new RuntimeException("No worker associated with this company could be found with this ID.");
    }
}
