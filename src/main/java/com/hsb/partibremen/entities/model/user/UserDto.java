package com.hsb.partibremen.entities.model.user;

import java.sql.Date;
import java.util.UUID;

import javax.management.relation.Role;

import com.hsb.partibremen.entities.enums.Rolle;

public class UserDto {

    private String name;
    private String surname;
    private Date dob;
    private String email;
    private String password;
    private boolean verified;
    private Rolle role;
    private boolean active;

 
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public Rolle getRole() {
        return role;
    }
    public void setRole(Rolle role) {
        this.role = role;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }

    

}
