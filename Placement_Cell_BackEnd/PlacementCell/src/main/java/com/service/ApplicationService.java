package com.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Application;
import com.repository.ApplicationRepository;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;

    // Save or Update Application
    public Application saveOrUpdateApplication(Application application) {
        if (application.getApplicationId() == null) {
            application.setCreatedDate(LocalDateTime.now());
        }
        application.setUpdateDate(LocalDateTime.now());
        return applicationRepository.save(application);
    }

    // Get All Applications
    public Iterable<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Get Application by ID
    public Optional<Application> getApplicationById(Long id) {
        return applicationRepository.findById(id);
    }

    // Delete Application
    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }
    
 // Get Applied Jobs by Candidate ID
    public List<Object[]> getAppliedJobsByCandidateId(Long candidateId) {
        return applicationRepository.findAppliedJobsByCandidateId(candidateId);
    }
    
 // Get Applications by Job ID
    public List<Object[]> getApplicationsByJobId(Long jobId) {
        return applicationRepository.findApplicationsByJobId(jobId);
    }
    
 // Method to get applications by Job ID and Status
    public List<Object[]> getApplicationsByJobIdAndStatus(Long jobId, String status) {
        return applicationRepository.findByJobIdAndStatus(jobId, status);
    }
    
}