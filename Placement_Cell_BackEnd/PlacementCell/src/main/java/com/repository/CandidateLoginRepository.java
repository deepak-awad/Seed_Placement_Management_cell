package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.dao.CandidateLogin;

public interface CandidateLoginRepository extends CrudRepository<CandidateLogin, Long> {
    // Custom query method to find a candidate login by username and password
    CandidateLogin findByUsernameAndPassword(String username, String password);
}