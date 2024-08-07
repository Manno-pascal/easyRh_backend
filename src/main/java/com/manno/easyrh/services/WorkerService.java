package com.manno.easyrh.services;


import com.manno.easyrh.dto.WorkerDTO;
import com.manno.easyrh.entities.Company;
import com.manno.easyrh.entities.Worker;
import com.manno.easyrh.mappers.WorkerMapper;
import com.manno.easyrh.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return null;
    }

    public boolean delete(int id) {
        Company company = securityService.getCompanySession();
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

    public List<WorkerDTO> getWorkersByCompany() {
        return this.workerRepository.findAllByCompany(securityService.getCompanySession()).stream().map(workerMapper::toDto).collect(Collectors.toList());
    }

    public WorkerDTO getWorkerById(int id) {
        Company company = securityService.getCompanySession();
        Worker worker = workerRepository.findById(id).orElse(null);
        if (worker == null) {
            return null;
        }
        if (company.getId() == worker.getCompany().getId()) {
            return this.workerMapper.toDto(worker);

        }
        return null;
    }

    public WorkerDTO patchWorker(int id, WorkerDTO updates) {
        Company company = securityService.getCompanySession();
        Worker worker = workerRepository.findById(id).orElse(null);
        if (worker == null) {
            return null;
        }
        if (company.getId() == worker.getCompany().getId()) {
                Worker modifiedWorker = workerMapper.toEntity(updates,worker);
            return workerMapper.toDto(workerRepository.save(modifiedWorker));
        }
        return null;
    }
}
