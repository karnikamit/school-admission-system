package com.karnikamit.school_admission_system.repositories;

import com.karnikamit.school_admission_system.models.AdmissionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<AdmissionRequest, Long> {

}

