package com.example.demoaxon.query;

import com.example.demoaxon.entities.ComplaintQueryObject;
import com.example.demoaxon.event.ComplaintFiledEvent;
import com.example.demoaxon.repository.ComplaintQueryObjectRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandQueryObjectUpdater {

    @Autowired
    private ComplaintQueryObjectRepository repository;

    @EventHandler
    public void on(ComplaintFiledEvent complaintFiledEvent) {
        ComplaintQueryObject complaintQueryObject = new ComplaintQueryObject(complaintFiledEvent.getId(),
                complaintFiledEvent.getMessage(), complaintFiledEvent.getCompany());
        this.repository.save(complaintQueryObject);
    }
}
