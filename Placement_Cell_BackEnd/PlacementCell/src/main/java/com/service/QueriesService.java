package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Queries;
import com.repository.QueriesRepository;

@Service
public class QueriesService {

    @Autowired
    private QueriesRepository queriesRepository;

    // Get all queries
    public Iterable<Queries> getAllQueries() {
        return queriesRepository.findAll();
    }

    // Get query by ID
    public Optional<Queries> getQueryById(Long id) {
        return queriesRepository.findById(id);
    }

    // Save or update query
    public Queries saveOrUpdateQuery(Queries query) {
        return queriesRepository.save(query);
    }

    // Delete query
    public void deleteQuery(Long id) {
        queriesRepository.deleteById(id);
    }
    
    // Fetch all queries by candidate ID (Fix: change List<Query> to List<Queries>)
    public List<Queries> getQueriesByCandidateId(Long candidateId) {
        return queriesRepository.findByCandidateId(candidateId);  // return List<Queries> not Query
    }
    
 // Method to get the total count of queries
    public Long getTotalQueriesCount() {
        return queriesRepository.count();
    }
}