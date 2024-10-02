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
import org.springframework.web.bind.annotation.RestController;

import com.dao.Queries;
import com.service.QueriesService;

@RestController
@RequestMapping("/queries")
public class QueriesController {

    @Autowired
    private QueriesService queriesService;

    // Get all queries
    @GetMapping("/all")
    public ResponseEntity<Iterable<Queries>> getAllQueries() {
        return new ResponseEntity<>(queriesService.getAllQueries(), HttpStatus.OK);
    }

    // Get query by ID
    @GetMapping("/{id}")
    public ResponseEntity<Queries> getQueryById(@PathVariable Long id) {
        Optional<Queries> query = queriesService.getQueryById(id);
        return query.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Create or update query
//    @PostMapping("/save")
//    public ResponseEntity<Queries> saveOrUpdateQuery(@RequestBody Queries query) {
//        return new ResponseEntity<>(queriesService.saveOrUpdateQuery(query), HttpStatus.CREATED);
//    }
    
    @PostMapping("/save")
    public ResponseEntity<Queries> saveOrUpdateQuery(@RequestBody Queries query) {
        // Automatically set created and updated dates
        query.setCreatedDate(LocalDateTime.now());
        query.setUpdatedDate(LocalDateTime.now());
        
        Queries savedQuery = queriesService.saveOrUpdateQuery(query);
        return new ResponseEntity<>(savedQuery, HttpStatus.CREATED);
    }

    // Delete query by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuery(@PathVariable Long id) {
        queriesService.deleteQuery(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
 // Fetch all queries by candidate ID (Fix: change List<Query> to List<Queries>)
    @GetMapping("/candidate/{candidateId}")
    public ResponseEntity<List<Queries>> getQueriesByCandidateId(@PathVariable Long candidateId) {
        try {
            List<Queries> queries = queriesService.getQueriesByCandidateId(candidateId);
            
            if (queries.isEmpty()) {
                return ResponseEntity.noContent().build();  // No queries found
            }
            
            return ResponseEntity.ok(queries);  // Queries found
        } catch (Exception e) {
            e.printStackTrace();  // Log the full stack trace
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);  // Return 500 error
        }
    }
    
 // Update query response and status
    @PutMapping("/update/{id}")
    public ResponseEntity<Queries> updateQueryResponse(@PathVariable Long id, @RequestBody Queries updatedQuery) {
        Optional<Queries> optionalQuery = queriesService.getQueryById(id);
        if (!optionalQuery.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        
        Queries existingQuery = optionalQuery.get();
        existingQuery.setResponse(updatedQuery.getResponse());
        existingQuery.setStatus(updatedQuery.getStatus());
        
        Queries savedQuery = queriesService.saveOrUpdateQuery(existingQuery);
        return ResponseEntity.ok(savedQuery);
    }
    
    
    // Get the total count of queries
    @GetMapping("/total-count")
    public ResponseEntity<Long> getTotalQueriesCount() {
        Long totalQueries = queriesService.getTotalQueriesCount();
        return ResponseEntity.ok(totalQueries);
    }
    
}