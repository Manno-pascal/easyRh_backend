package com.manno.easyrh.controllers;


import com.manno.easyrh.entities.Worker;
import com.manno.easyrh.services.WorkerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(path = "worker")
public class WorkerController {

    private final WorkerService workerservice;


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE )
    public Worker create(@RequestBody Worker worker) {return this.workerservice.create(worker);}

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "{id}")
    public void delete(@PathVariable int id) {this.workerservice.delete(id);}

    @ResponseStatus()
    @GetMapping(path="company", produces = APPLICATION_JSON_VALUE)
    public List<Worker> getWorkersByCompany() {return this.workerservice.getWorkersByCompany();}

    @ResponseStatus()
    @GetMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Worker getWorkerById(@PathVariable int id) {return this.workerservice.getWorkerById(id);}

    @ResponseStatus()
    @PatchMapping(path = "{id}", produces = APPLICATION_JSON_VALUE)
    public Worker patchWorker(@PathVariable int id, @RequestBody Map<String, Object> updates) {return this.workerservice.patchWorker(id, updates);}

}
