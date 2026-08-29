package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.EcuHealth;
import com.ovcvp.telematics.domain.EcuStatus;
import com.ovcvp.telematics.domain.TelemetryEvent;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TelemetrySimulationService {

    private final VehicleStateService vehicleStateService;
    private final ConnectivityStateService connectivityStateService;

    public TelemetrySimulationService(
            VehicleStateService vehicleStateService,
            ConnectivityStateService connectivityStateService) {
        this.vehicleStateService = vehicleStateService;
        this.connectivityStateService = connectivityStateService;
    }

    public TelemetryEvent generateTelemetry() {

        EcuHealth ecuHealth = new EcuHealth(
                "TCU-001",
                EcuStatus.HEALTHY,
                8400,
                0
        );

        return new TelemetryEvent(
                Instant.now(),
                vehicleStateService.getCurrentState(),
                connectivityStateService.getCurrentState(),
                ecuHealth
        );
    }
}