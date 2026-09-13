package com.ovcvp.telematics.messaging;

import com.ovcvp.telematics.domain.TelemetryEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class TelemetryKafkaConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(TelemetryKafkaConsumer.class);

    @KafkaListener(
            topics = "vehicle.telemetry",
            groupId = "telemetry-validation-group"
    )
    public void consume(
            ConsumerRecord<String, TelemetryEvent> record) {

        TelemetryEvent event = record.value();

        log.info(
                "Consumed telemetry: key={}, partition={}, offset={}, vehicle={}",
                record.key(),
                record.partition(),
                record.offset(),
                event.getVehicleState().getVehicleId()
        );
    }
}