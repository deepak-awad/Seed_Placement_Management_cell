package com.dao;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "candidate_registration")
public class CandidateRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_seq")
    @SequenceGenerator(name = "candidate_seq", sequenceName = "candidate_seq", allocationSize = 1)
    private Long candidateId;
    
    @Column(name = "candidate_name")
    private String name;
    @Column(name = "candidate_email")
    private String email;
    @Column(name = "candidate_mobile")
    private String mobile;
    @Column(name = "candidate_password")
    private String password;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    // Getters and Setters
    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}