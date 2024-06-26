package com.hsb.partibremen.entities.model.user;

import com.hsb.partibremen.entities.enums.BlockStatus;
import com.hsb.partibremen.entities.enums.Role;
import com.hsb.partibremen.entities.enums.Role;
import com.hsb.partibremen.entities.util.BaseEntity;
import jakarta.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Entity
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET is_deleted = true WHERE id=?")
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
    private Boolean verified;
    @Column
    private Role role;
    @Column
    private Boolean active;
    @Enumerated(EnumType.STRING)
    private BlockStatus blockStatus = BlockStatus.UNBLOCKED;
    @Column
    private LocalDate blockUntilDatum;

    @Column(nullable = true)
    private String img;


    public String getImg() {
        return img;
    }
    public void setImg(String img) {
        this.img = img;
    }
    public LocalDate getBlockUntilDatum() {
        return blockUntilDatum;
    }
    public void setBlockUntilDatum(LocalDate blockUntilDate) {
        this.blockUntilDatum = blockUntilDate;
    }
    public BlockStatus getBlockStatus() {
        return blockStatus;
    }
    public void setBlockStatus(BlockStatus blockStatus) {
        this.blockStatus = blockStatus;
    }
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
    public Boolean isVerified() {
        return verified;
    }
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
    
}
