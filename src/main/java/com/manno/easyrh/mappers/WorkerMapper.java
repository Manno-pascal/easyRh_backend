package com.manno.easyrh.mappers;


import com.manno.easyrh.dto.WorkerDTO;
import com.manno.easyrh.entities.Worker;
import com.manno.easyrh.repositories.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class WorkerMapper {
    private final CompanyMapper companyMapper;
    private final CompanyRepository companyRepository;

    public WorkerDTO toDto(Worker worker) {
        WorkerDTO dto = new WorkerDTO();
        dto.setId(worker.getId());
        dto.setFirstname(worker.getFirstname());
        dto.setLastname(worker.getLastname());
        dto.setPosition(worker.getPosition());
        dto.setPositionType(worker.getPositionType());
        dto.setGender(worker.getGender());
        dto.setAge(worker.getAge());
        dto.setWarning(worker.getWarning());
        if (dto.getComment() != null) {
            dto.setComment(worker.getComment());
        }
        dto.setRqth(worker.isRqth());
        dto.setDayOff(worker.getDayOff());
        dto.setPhoneNumber(worker.getPhoneNumber());
        dto.setEmail(worker.getEmail());
        dto.setCeo(worker.isCeo());
        dto.setRh(worker.isRh());
        dto.setCountry(worker.getCountry());
        dto.setAddress(worker.getAddress());
        dto.setZip(worker.getZip());
        dto.setCity(worker.getCity());
        dto.setCompany(companyMapper.toDto(worker.getCompany()));
        return dto;
    }

    public Worker toEntity(WorkerDTO dto, Worker worker) {
        if (dto.getFirstname() != null) {
            worker.setFirstname(dto.getFirstname());
        }
        if (dto.getLastname() != null) {
            worker.setLastname(dto.getLastname());
        }
        if (dto.getCity() != null) {
            worker.setLastname(dto.getCity());
        }
        if (dto.getPosition() != null) {
            worker.setPosition(dto.getPosition());
        }
        if (dto.getPositionType() != null) {
            worker.setPositionType(dto.getPositionType());
        }
        if (dto.getGender() != null) {
            worker.setGender(dto.getGender());
        }
        if (dto.getAge() != 0) {
            worker.setAge(dto.getAge());
        }
        if (dto.getWarning() != 0) {
            worker.setWarning(dto.getWarning());
        }
        if (dto.getComment() != null) {
            worker.setComment(dto.getComment());
        }
        worker.setRqth(dto.isRqth());

        if (dto.getDayOff() != 0) {
            worker.setDayOff(dto.getDayOff());
        }
        if (dto.getPhoneNumber() != null) {
            worker.setPhoneNumber(dto.getPhoneNumber());
        }
        if (dto.getEmail() != null) {
            worker.setEmail(dto.getEmail());
        }
        worker.setCeo(dto.isCeo());
        worker.setRh(dto.isRh());
        if (dto.getCountry() != null) {
            worker.setCountry(dto.getCountry());
        }
        if (dto.getAddress() != null) {
            worker.setAddress(dto.getAddress());
        }
        if (dto.getZip() != null) {
            worker.setZip(dto.getZip());
        }
        if (dto.getCity() != null) {
            worker.setCity(dto.getCity());
        }
        return worker;
    }

    public Worker toEntity(WorkerDTO dto) {
        Worker worker = new Worker();
        worker.setFirstname(dto.getFirstname());
        worker.setLastname(dto.getLastname());
        worker.setPosition(dto.getPosition());
        worker.setPositionType(dto.getPositionType());
        worker.setGender(dto.getGender());
        worker.setAge(dto.getAge());
        worker.setWarning(dto.getWarning());
        if (worker.getComment() != null) {
            worker.setComment(dto.getComment());
        }
        worker.setRqth(dto.isRqth());
        worker.setDayOff(dto.getDayOff());
        worker.setPhoneNumber(dto.getPhoneNumber());
        worker.setEmail(dto.getEmail());
        worker.setCeo(dto.isCeo());
        worker.setRh(dto.isRh());
        worker.setCountry(dto.getCountry());
        worker.setAddress(dto.getAddress());
        worker.setZip(dto.getZip());
        worker.setCity(dto.getCity());
        worker.setCompany(companyRepository.findById(dto.getCompany().getId()).get());
        return worker;
    }
}
