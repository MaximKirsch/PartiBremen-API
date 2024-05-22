package com.hsb.partibremen.entities.model.user;

import com.hsb.partibremen.entities.enums.Role;
import com.hsb.partibremen.entities.enums.Role;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name = "user")
public class User extends BaseEntity {

    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Date dob;
    @Column
    private String email;
    @Column
    private String password;
    @Column
    private boolean verified;
    @Column
    private Role role;
    @Column
    private Boolean active;
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
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
    public boolean isVerified() {
        return verified;
    }
    public void setVerified(boolean verified) {
        this.verified = verified;
    }
    
}
