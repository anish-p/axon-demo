package com.example.demoaxon.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ComplaintQueryObject {

    @Id
    private String id;
    private String message;
    private String company;

    public ComplaintQueryObject() {
    }

    public ComplaintQueryObject(String id, String message, String company) {
        this.id = id;
        this.message = message;
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
