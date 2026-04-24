package com.karnikamit.school_admission_system.restController;

import com.karnikamit.school_admission_system.models.AdmissionRequest;
import com.karnikamit.school_admission_system.models.ApiResponse;
import com.karnikamit.school_admission_system.repositories.AdmissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/school")
public class SchoolAdmissionController {

    private static final Logger logger = LoggerFactory.getLogger(SchoolAdmissionController.class);

    @Autowired
    private AdmissionRepository admissionRepository;

    @Autowired
    private KafkaTemplate<String, AdmissionRequest> kafkaTemplate;

    private static final String TOPIC = "admission_requests";

    @Transactional
    @PostMapping("/admission-request")
    public ResponseEntity<ApiResponse<String>> handleAdmissionRequest(@RequestBody AdmissionRequest admissionRequest) {
        logger.info("Received admission request for: {}", admissionRequest.getName());
        try{
            // Logic to process admission (e.g., saving to DB)
            String admissionId = "ADM-" + UUID.randomUUID().toString().substring(0, 8);

            ApiResponse<String> response = new ApiResponse<>(
                    "Admission request submitted successfully!",
                    true,
                    admissionId
            );

            // 1. Save to Postgres
            AdmissionRequest savedRequest = saveRequest(admissionRequest);

            // 2. Send the saved object (with its new ID) to Kafka
            kafkaTemplate.send(TOPIC, savedRequest.getId().toString(), savedRequest);

            // Process the admission request and return a response
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (Exception e) {
            ApiResponse<String> errorResponse = new ApiResponse<>(
                    "Failed to submit request: " + e.getMessage(),
                    false,
                    null
            );

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @Transactional
    public AdmissionRequest saveRequest(AdmissionRequest request) {
        return admissionRepository.saveAndFlush(request);
    }
}
