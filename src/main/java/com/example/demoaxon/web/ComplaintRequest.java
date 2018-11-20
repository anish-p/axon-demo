package com.example.demoaxon.web;

public class ComplaintRequest {

    private String company;
    private String message;

    public ComplaintRequest(String company, String message) {
        this.company = company;
        this.message = message;
    }

    public ComplaintRequest() {
    }

    public String getCompany() {
        return company;
    }

    public String getMessage() {
        return message;
    }
}
