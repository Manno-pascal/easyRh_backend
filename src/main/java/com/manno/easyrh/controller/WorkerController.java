package com.manno.easyrh.controller;


import com.manno.easyrh.dto.WorkerDTO;
import com.manno.easyrh.service.WorkerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "worker")
public class WorkerController {

    private final WorkerService workerservice;

    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> create(@RequestBody WorkerDTO workerDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(workerservice.create(workerDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        try {
            this.workerservice.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("The worker has been successfully deleted.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }

    }

    @GetMapping(path = "company", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getWorkersByCompany() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.workerservice.getWorkersByCompany());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getWorkerById(@PathVariable int id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(this.workerservice.getWorkerById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping(path = "{id}", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> patchWorker(@PathVariable int id, @Valid @RequestBody WorkerDTO updates, BindingResult bindingResult) {
        try {
            if (bindingResult.hasErrors()) {
                throw new RuntimeException(bindingResult.getFieldError().getDefaultMessage());
            }
            return ResponseEntity.status(HttpStatus.OK).body(this.workerservice.patchWorker(id, updates));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
