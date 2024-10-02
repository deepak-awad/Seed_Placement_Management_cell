package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.dao.Application;

public interface ApplicationRepository extends CrudRepository<Application, Long> {

    @Query(value = "SELECT j.company_name, j.job_title, a.status " +
                   "FROM job_post j " +
                   "INNER JOIN application a ON j.job_id = a.job_id " +
                   "WHERE a.candidate_id = :candidateId AND a.PREDEFINEDSTATUS = 'Applied'", 
           nativeQuery = true)
    List<Object[]> findAppliedJobsByCandidateId(@Param("candidateId") Long candidateId);
    
    @Query(value = "SELECT a.* " +
            "FROM application a " +
            "INNER JOIN candidate_registration c ON a.candidate_id = c.candidate_id " +
            "WHERE a.job_id = :jobId", 
    nativeQuery = true)
    List<Object[]> findApplicationsByJobId(@Param("jobId") Long jobId);
    
    @Query("SELECT a FROM Application a WHERE a.jobId = :jobId AND a.status = :status")
    List<Object[]> findByJobIdAndStatus(@Param("jobId") Long jobId, @Param("status") String status);
}
