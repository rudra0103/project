package com.example.myapplication.model;

import java.io.Serializable;

public class PersonModel implements Serializable {

    public PersonModel(String id, String username, String email, String mobileno, String password, String status, String updated_at, String created_at) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.mobileno = mobileno;
        this.password = password;
        this.status = status;
        this.updated_at = updated_at;
        this.created_at = created_at;
    }

    public String get_id() {
        return id;
    }

    public void set_id(String _id) {
        this.id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    String id,username,email,mobileno,password,status,updated_at,created_at;
}
