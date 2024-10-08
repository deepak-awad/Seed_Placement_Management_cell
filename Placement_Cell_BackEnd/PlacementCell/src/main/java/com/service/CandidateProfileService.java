package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.CandidateProfile;
import com.repository.CandidateProfileRepository;

@Service
public class CandidateProfileService {

    @Autowired
    private CandidateProfileRepository candidateProfileRepository;

    public Iterable<CandidateProfile> getAllCandidateProfiles() {
        return candidateProfileRepository.findAll();
    }

    public Optional<CandidateProfile> getCandidateProfileById(Long candidateProfileId) {
        return candidateProfileRepository.findById(candidateProfileId);
    }

    // Method to save profile with resume link
    public CandidateProfile saveCandidateProfile(CandidateProfile profile) {
        return candidateProfileRepository.save(profile);
    }

    public void deleteCandidateProfile(Long candidateProfileId) {
        candidateProfileRepository.deleteById(candidateProfileId);
    }
}