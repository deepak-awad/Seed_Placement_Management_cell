package com.repository;

import org.springframework.data.repository.CrudRepository;

import com.dao.CandidateProfile;

public interface CandidateProfileRepository extends CrudRepository<CandidateProfile, Long> {
    // Define custom query methods here if needed
}
