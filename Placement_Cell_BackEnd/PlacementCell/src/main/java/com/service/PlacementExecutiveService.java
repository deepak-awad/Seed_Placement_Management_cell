package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PlacementExecutive;
import com.repository.PlacementExecutiveRepository;

@Service
public class PlacementExecutiveService {

    @Autowired
    private PlacementExecutiveRepository placementExecutiveRepository;

    public Optional<PlacementExecutive> getExecutiveByUsername(String username) {
        return placementExecutiveRepository.findByUsername(username);
    }

    public Optional<PlacementExecutive> checkExecutiveByUsernameAndPassword(String username, String password) {
        return placementExecutiveRepository.findByUsernameAndPassword(username, password);
    }
}
