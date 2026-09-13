package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.TelemetryEvent;
import com.ovcvp.telematics.messaging.TelemetryKafkaProducer;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TelemetrySimulationService {

    private final VehicleStateService vehicleStateService;
    private final ConnectivityStateService connectivityStateService;
    private final EcuHealthService ecuHealthService;
    private final TelemetryKafkaProducer telemetryKafkaProducer;

    public TelemetrySimulationService(
            VehicleStateService vehicleStateService,
            ConnectivityStateService connectivityStateService,
            EcuHealthService ecuHealthService, TelemetryKafkaProducer telemetryKafkaProducer) {
        this.vehicleStateService = vehicleStateService;
        this.connectivityStateService = connectivityStateService;
        this.ecuHealthService = ecuHealthService;
        this.telemetryKafkaProducer = telemetryKafkaProducer;
    }

    public TelemetryEvent generateTelemetry() {
        return new TelemetryEvent(
                Instant.now(),
                vehicleStateService.getCurrentState(),
                connectivityStateService.getCurrentState(),
                ecuHealthService.getCurrentState()
        );
    }

    public TelemetryEvent generateAndPublishTelemetry() {

        TelemetryEvent event = generateTelemetry();

        telemetryKafkaProducer.send(event);

        return event;
    }
}