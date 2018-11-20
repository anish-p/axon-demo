package com.example.demoaxon.web;

import com.example.demoaxon.command.FileComplaintCommand;
import com.example.demoaxon.entities.ComplaintQueryObject;
import com.example.demoaxon.repository.ComplaintQueryObjectRepository;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
public class ComplaintsController {

    @Autowired
    private final ComplaintQueryObjectRepository complaintRepository;

    @Autowired
    private final CommandGateway commandGateway;

    public ComplaintsController(ComplaintQueryObjectRepository complaintRepository, CommandGateway commandGateway) {
        this.complaintRepository = complaintRepository;
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public CompletableFuture<String> fileComplaint(@RequestBody ComplaintRequest complaintRequest) {
        return this.commandGateway
                .send(new FileComplaintCommand(UUID.randomUUID().toString(), complaintRequest.getMessage(),
                        complaintRequest.getCompany()));
    }

    @GetMapping
    public List<ComplaintQueryObject> findAll() {
        return this.complaintRepository.findAll();
    }

    @GetMapping("/{id}")
    public ComplaintQueryObject find(@PathVariable String id) {
        return this.complaintRepository.findById(id).get();
    }
}
