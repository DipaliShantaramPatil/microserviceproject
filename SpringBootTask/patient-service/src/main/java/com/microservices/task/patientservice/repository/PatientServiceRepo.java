package com.microservices.task.patientservice.repository;

import com.microservices.task.patientservice.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientServiceRepo extends JpaRepository<Patient, Integer> {
}