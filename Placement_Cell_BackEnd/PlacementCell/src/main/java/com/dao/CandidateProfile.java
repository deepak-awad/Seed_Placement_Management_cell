package com.dao;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "candidate_profile")
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "candidate_profile_seq_gen")
    @SequenceGenerator(name = "candidate_profile_seq_gen", sequenceName = "candidate_profile_seq", allocationSize = 1)
    @Column(name = "candidate_profile_id")
    private Long candidateProfileId;

    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "full_name")
    private String name;

    @Column(name = "email_id")
    private String email;

    @Column(name = "mobile_number")
    private String mobile;

    @Column(name = "password")
    private String password;

    @Column(name = "course")
    private String course;

    @Column(name = "graduation")
    private String graduation;

    @Column(name = "specialization")
    private String specialization;

    @Column(name = "university_name")
    private String universityName;

    @Column(name = "passing_year")
    private Integer passingYear;

    @Column(name = "gender")
    private String gender;

    // Update to store the resume link instead of a byte array
    @Column(name = "resume")
    private String resume;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

	public Long getCandidateProfileId() {
		return candidateProfileId;
	}

	public void setCandidateProfileId(Long candidateProfileId) {
		this.candidateProfileId = candidateProfileId;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public String getFullName() {
		return name;
	}

	public void setFullName(String fullName) {
		this.name = fullName;
	}

	public String getEmailId() {
		return email;
	}

	public void setEmailId(String emailId) {
		this.email = emailId;
	}

	public String getMobileNumber() {
		return mobile;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobile = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGraduation() {
		return graduation;
	}

	public void setGraduation(String graduation) {
		this.graduation = graduation;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Integer getPassingYear() {
		return passingYear;
	}

	public void setPassingYear(Integer passingYear) {
		this.passingYear = passingYear;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

    // Getters and Setters

    
}