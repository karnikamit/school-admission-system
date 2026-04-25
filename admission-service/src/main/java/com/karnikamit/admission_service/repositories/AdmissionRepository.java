package com.karnikamit.admission_service.repositories;

import com.karnikamit.admission_service.models.AdmissionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionRepository extends JpaRepository<AdmissionRequest, Long> {

}

