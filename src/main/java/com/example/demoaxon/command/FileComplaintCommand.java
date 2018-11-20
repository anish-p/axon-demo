package com.example.demoaxon.command;

import org.springframework.stereotype.Component;

@Component
public class FileComplaintCommand {

    private String id;
    private String message;
    private String company;

    public FileComplaintCommand() {
    }

    public FileComplaintCommand(String id, String message, String company) {
        this.id = id;
        this.message = message;
        this.company = company;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCompany() {
        return company;
    }
}
