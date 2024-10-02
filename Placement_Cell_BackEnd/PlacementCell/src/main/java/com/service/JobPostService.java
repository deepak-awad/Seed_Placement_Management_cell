package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.JobPost;
import com.repository.JobPostRepository;

import java.util.Optional;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    public Iterable<JobPost> getAllJobPosts() {
        return jobPostRepository.findAll();
    }

    public Optional<JobPost> getJobPostById(Long jobId) {
        return jobPostRepository.findById(jobId);
    }

    public JobPost saveOrUpdateJobPost(JobPost jobPost) {
        return jobPostRepository.save(jobPost);
    }

    public void deleteJobPost(Long jobId) {
        jobPostRepository.deleteById(jobId);
    }
    
    // Method to get the total count of job posts
    public Long getTotalJobPostCount() {
        return jobPostRepository.count();
    }
}