package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.dao.JobPost;

public interface JobPostRepository extends CrudRepository<JobPost, Long> {
    // You can add custom queries here if needed
}