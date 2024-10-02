package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CandidateLogin;
import com.repository.CandidateLoginRepository;

@Service
public class CandidateLoginService {

    @Autowired
    private CandidateLoginRepository candidateLoginRepository;

    public Iterable<CandidateLogin> getAllLogins() {
        return candidateLoginRepository.findAll();
    }

    public Optional<CandidateLogin> getLoginById(Long loginId) {
        return candidateLoginRepository.findById(loginId);
    }

    public CandidateLogin saveLogin(CandidateLogin candidateLogin) {
        return candidateLoginRepository.save(candidateLogin);
    }

    public void deleteLogin(Long loginId) {
        candidateLoginRepository.deleteById(loginId);
    }

    public CandidateLogin validateLogin(String username, String password) {
        return candidateLoginRepository.findByUsernameAndPassword(username, password);
    }
}