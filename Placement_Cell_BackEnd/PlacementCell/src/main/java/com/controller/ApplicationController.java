package com.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.Application;
import com.service.ApplicationService;

@RestController
@RequestMapping("/applications")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    // Get all applications
    @GetMapping("/all")
    public ResponseEntity<Iterable<Application>> getAllApplications() {
        return new ResponseEntity<>(applicationService.getAllApplications(), HttpStatus.OK);
    }

    // Get application by ID
    @GetMapping("/{id}")
    public ResponseEntity<Application> getApplicationById(@PathVariable Long id) {
        Optional<Application> application = applicationService.getApplicationById(id);
        return application.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update an application
    @PostMapping("/save")
    public ResponseEntity<Application> createOrUpdateApplication(@RequestBody Application application) {
        return new ResponseEntity<>(applicationService.saveOrUpdateApplication(application), HttpStatus.CREATED);
    }

    // Delete an application
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
 // Get applied jobs by candidate ID
    @GetMapping("/applied/candidate/{id}")
    public ResponseEntity<List<Object[]>> getAppliedJobsByCandidateId(@PathVariable Long id) {
        List<Object[]> applications = applicationService.getAppliedJobsByCandidateId(id);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    
 // Get applications by Job ID
    @GetMapping("/job/{jobId}")
    public ResponseEntity<List<Object[]>> getApplicationsByJobId(@PathVariable Long jobId) {
        List<Object[]> applications = applicationService.getApplicationsByJobId(jobId);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }
    
 // Update status by Application ID
    @PutMapping("/update-status/{id}")
    public ResponseEntity<Application> updateApplicationStatus(@PathVariable Long id, @RequestBody String status) {
        // Fetch the application by its ID
        Optional<Application> optionalApplication = applicationService.getApplicationById(id);
        
        if (optionalApplication.isPresent()) {
            // Get the application object
            Application application = optionalApplication.get();
            
            // Update the status field
            application.setStatus(status);
            
            // Update the predefined status if necessary
            if (status.equalsIgnoreCase("Accepted")) {
                application.setPredefindstatus("Accepted");
            } else if (status.equalsIgnoreCase("Rejected")) {
                application.setPredefindstatus("Rejected");
            }
            
            // Save the updated application
            Application updatedApplication = applicationService.saveOrUpdateApplication(application);
            
            // Return the updated application with HTTP 200 OK
            return new ResponseEntity<>(updatedApplication, HttpStatus.OK);
        } else {
            // If application is not found, return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Get applications by Job ID and Status
    @GetMapping("/job/{jobId}/{status}")
    public ResponseEntity<List<Object[]>> getApplicationsByJobIdAndStatus(
            @PathVariable Long jobId, 
            @PathVariable String status) {
        List<Object[]> applications = applicationService.getApplicationsByJobIdAndStatus(jobId, status);
        return new ResponseEntity<>(applications, HttpStatus.OK);
    }

    
}