package com.example.myapplication.model;

public class PersonOutputModel {
    Boolean status;
    String message;

    PersonModel person;

    public PersonOutputModel(Boolean status, String message, PersonModel person) {
        this.status = status;
        this.message = message;
        this.person = person;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }
}
