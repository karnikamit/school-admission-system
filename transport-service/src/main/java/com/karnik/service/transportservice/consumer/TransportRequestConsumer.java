package com.karnik.service.transportservice.consumer;

import com.karnikamit.admission_service.models.AdmissionRequest;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.karnikamit.admission_service.util.Constants.KAFKA_TOPIC;

@Service
public class TransportRequestConsumer {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(TransportRequestConsumer.class);

    @KafkaListener(topics = KAFKA_TOPIC, groupId = "transport-group")
    public void consume(AdmissionRequest request) {
        logger.info("ACTION: Initiating bus route assignment for Student: {} address: {}", request.getName(), request.getAddress());
    }
}
