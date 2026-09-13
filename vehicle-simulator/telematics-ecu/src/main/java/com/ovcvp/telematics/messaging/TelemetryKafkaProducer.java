package com.ovcvp.telematics.messaging;

import com.ovcvp.telematics.domain.TelemetryEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class TelemetryKafkaProducer {

    private static final Logger log =
            LoggerFactory.getLogger(TelemetryKafkaProducer.class);

    private final KafkaTemplate<String, TelemetryEvent> kafkaTemplate;

    public TelemetryKafkaProducer(
            KafkaTemplate<String, TelemetryEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(TelemetryEvent event) {

        String vehicleId =
                event.getVehicleState().getVehicleId();

        kafkaTemplate
                .send("vehicle.telemetry", vehicleId, event)
                .whenComplete((result, error) -> {

                    if (error != null) {
                        log.error(
                                "Failed to publish telemetry for {}",
                                vehicleId,
                                error
                        );
                        return;
                    }

                    log.info(
                            "Published telemetry: vehicle={}, partition={}, offset={}",
                            vehicleId,
                            result.getRecordMetadata().partition(),
                            result.getRecordMetadata().offset()
                    );
                });
    }
}