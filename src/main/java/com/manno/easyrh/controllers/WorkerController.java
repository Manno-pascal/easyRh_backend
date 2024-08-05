package com.manno.easyrh.controllers;


import com.manno.easyrh.entities.Worker;
import com.manno.easyrh.services.WorkerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "worker")
public class WorkerController {

    private final WorkerService workerservice;

    public WorkerController(WorkerService workerservice) {
        this.workerservice = workerservice;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void create(@RequestBody Worker worker) {

        this.workerservice.create(worker);
    }

}
