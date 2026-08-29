package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.TelemetryEvent;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TelemetrySimulationService {

    private final VehicleStateService vehicleStateService;
    private final ConnectivityStateService connectivityStateService;
    private final EcuHealthService ecuHealthService;

    public TelemetrySimulationService(
            VehicleStateService vehicleStateService,
            ConnectivityStateService connectivityStateService,
            EcuHealthService ecuHealthService) {
        this.vehicleStateService = vehicleStateService;
        this.connectivityStateService = connectivityStateService;
        this.ecuHealthService = ecuHealthService;
    }

    public TelemetryEvent generateTelemetry() {
        return new TelemetryEvent(
                Instant.now(),
                vehicleStateService.getCurrentState(),
                connectivityStateService.getCurrentState(),
                ecuHealthService.getCurrentState()
        );
    }
}