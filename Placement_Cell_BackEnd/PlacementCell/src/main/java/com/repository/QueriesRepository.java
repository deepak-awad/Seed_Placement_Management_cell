package com.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dao.Queries;

@Repository
public interface QueriesRepository extends CrudRepository<Queries, Long> {
	
	  List<Queries> findByCandidateId(Long candidateId);  // Return List<Queries> 
	
}