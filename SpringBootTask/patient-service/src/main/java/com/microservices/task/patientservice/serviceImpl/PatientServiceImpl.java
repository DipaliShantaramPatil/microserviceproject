package com.microservices.task.patientservice.serviceImpl;

import com.microservices.task.patientservice.entity.Patient;
import com.microservices.task.patientservice.repository.PatientServiceRepo;
import com.microservices.task.patientservice.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientServiceRepo patientServiceRepo;

    @Override
    public Patient createPatient(Patient patient) {
        return patientServiceRepo.save(patient);
    }

    @Override
    public Optional<Patient> getOnePatient(int id) {
        return patientServiceRepo.findById(id);
    }

    @Override
    public List<Patient> getAllPatient() {
        return patientServiceRepo.findAll();
    }

    @Override
    public Patient updatePatient(int id, Patient updatedPatient) {
        Patient patient=patientServiceRepo.findById(id).get();
        if(updatedPatient.getFirstName()!=null)
        {
            patient.setFirstName(updatedPatient.getFirstName());
        }
        if(updatedPatient.getLastName()!=null)
        {
            patient.setLastName(updatedPatient.getLastName());
        }
        if(updatedPatient.getEmailId()!=null)
        {
            patient.setEmailId(updatedPatient.getEmailId());
        }
        if(updatedPatient.getGender()!=null)
        {
            patient.setGender(updatedPatient.getGender());
        }

        return patientServiceRepo.save(patient);
    }

    @Override
    public void deletePatient(int id) {
        patientServiceRepo.deleteById(id);
    }
}
