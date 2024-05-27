package com.hsb.partibremen.entities.model.user;

import com.hsb.partibremen.entities.enums.BlockStatus;
import com.hsb.partibremen.entities.enums.Role;

import java.time.LocalDate;
import java.sql.Date;

public class UserDto {

    private String name;
    private String surname;
    private Date dob;
    private String email;
    private String password;
    private Boolean verified;
    private Role role;
    private BlockStatus blockStatus; 
    private LocalDate blockUntilDatum;

    public LocalDate getBlockUntilDatum() {
        return blockUntilDatum;
    }
    public void setBlockUntilDatum(LocalDate blockUntilDatum) {
        this.blockUntilDatum = blockUntilDatum;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
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
    public Boolean isVerified() {
        return verified;
    }
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
    public BlockStatus getBlockStatus() {
        return blockStatus;
    }
    public void setBlockStatus(BlockStatus blockStatus) {
        this.blockStatus = blockStatus;
    }

    

}
