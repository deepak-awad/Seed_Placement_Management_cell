package com.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "candidate_login")
public class CandidateLogin {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_login_seq_gen")
    @SequenceGenerator(name = "candidate_login_seq_gen", sequenceName = "candidate_login_seq", allocationSize = 1)
    @Column(name = "login_id")
    private Long loginId;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    // Getters and Setters
    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Constructors
    public CandidateLogin() {
    }

    public CandidateLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }
}