package com.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CandidateLogin;
import com.service.CandidateLoginService;

@RestController
@RequestMapping("/login")
public class CandidateLoginController {

    @Autowired
    private CandidateLoginService candidateLoginService;

    // Get all logins (for admin or testing purposes)
    @GetMapping("/all")
    public ResponseEntity<Iterable<CandidateLogin>> getAllLogins() {
        return new ResponseEntity<>(candidateLoginService.getAllLogins(), HttpStatus.OK);
    }

    // Get login by ID
    @GetMapping("/{id}")
    public ResponseEntity<CandidateLogin> getLoginById(@PathVariable Long id) {
        Optional<CandidateLogin> candidateLogin = candidateLoginService.getLoginById(id);
        return candidateLogin.map(login -> new ResponseEntity<>(login, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create a new login (registration)
    @PostMapping("/register")
    public ResponseEntity<CandidateLogin> createLogin(@RequestBody CandidateLogin candidateLogin) {
        return new ResponseEntity<>(candidateLoginService.saveLogin(candidateLogin), HttpStatus.CREATED);
    }

    // Delete a login (for admin or testing purposes)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable Long id) {
        candidateLoginService.deleteLogin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Validate login credentials
    @PostMapping("/validate")
    public ResponseEntity<CandidateLogin> validateLogin(@RequestBody CandidateLogin candidateLogin) {
        CandidateLogin validLogin = candidateLoginService.validateLogin(candidateLogin.getUsername(), candidateLogin.getPassword());
        if (validLogin != null) {
            return new ResponseEntity<>(validLogin, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
}
