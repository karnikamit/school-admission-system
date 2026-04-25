package com.karnik.librarymanagementservice.consumer;

import com.karnikamit.admission_service.models.AdmissionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.karnikamit.admission_service.util.Constants.KAFKA_TOPIC;

@Service
public class LibraryRequestConsumer {

    private static final Logger logger = LoggerFactory.getLogger(LibraryRequestConsumer.class);

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "library-management-group")
    public void consume(AdmissionRequest request) {
        logger.info("ACTION: Initiating library card issuance for Student: {}", request.getName());
    }
}
