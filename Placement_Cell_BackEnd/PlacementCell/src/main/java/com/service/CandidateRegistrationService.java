package com.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CandidateRegistration;
import com.repository.CandidateRegistrationRepository;

@Service
public class CandidateRegistrationService {

    @Autowired
    private CandidateRegistrationRepository repository;

    // Get all candidates
    public Iterable<CandidateRegistration> getAllCandidates() {
        return repository.findAll();
    }

    // Get candidate by ID
    public Optional<CandidateRegistration> getCandidateById(Long id) {
        return repository.findById(id);
    }

    // Register a new candidate
    public CandidateRegistration registerCandidate(CandidateRegistration candidate) {
        candidate.setCreatedDate(java.time.LocalDateTime.now());
        return repository.save(candidate);
    }

    // Delete a candidate
    public void deleteCandidate(Long id) {
        repository.deleteById(id);
    }
	
	public Optional<CandidateRegistration> checkCandidateByEmailAndPassword(String email, String password) {
	    // Ensure you return Optional.empty() instead of null if no candidate is found
	    return repository.findByEmailAndPassword(email, password);
	}
	
	public Optional<CandidateRegistration> getCandidateByEmail(String email) {
	    return repository.findByEmail(email); // Ensure this returns Optional
	}
	
	// Method to get the total count of registered candidates
    public Long getTotalCandidateCount() {
        return repository.count();
    }


	
}