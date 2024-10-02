package com.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.dao.CandidateRegistration;

public interface CandidateRegistrationRepository extends CrudRepository<CandidateRegistration, Long> {

	Optional<CandidateRegistration> findByEmail(String email);

	Optional<CandidateRegistration> findByEmailAndPassword(String email, String password);
}
