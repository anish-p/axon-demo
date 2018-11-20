package com.example.demoaxon.aggregate;

import com.example.demoaxon.command.FileComplaintCommand;
import com.example.demoaxon.event.ComplaintFiledEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Complaint {

    @AggregateIdentifier
    private String complaintId;


    @CommandHandler
    public Complaint(FileComplaintCommand fileComplaintCommand) {
        apply(new ComplaintFiledEvent(fileComplaintCommand.getId(),
                fileComplaintCommand.getMessage(), fileComplaintCommand.getCompany()));
    }

    @EventSourcingHandler
    public void on(ComplaintFiledEvent complaintFiledEvent) {
        this.complaintId = complaintFiledEvent.getId();
    }
}
