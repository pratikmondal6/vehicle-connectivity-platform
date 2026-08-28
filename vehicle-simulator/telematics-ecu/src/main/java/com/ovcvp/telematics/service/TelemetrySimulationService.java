package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.ConnectivityState;
import com.ovcvp.telematics.domain.ConnectivityStatus;
import com.ovcvp.telematics.domain.EcuHealth;
import com.ovcvp.telematics.domain.EcuStatus;
import com.ovcvp.telematics.domain.TelemetryEvent;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TelemetrySimulationService {

    private final VehicleStateService vehicleStateService;

    public TelemetrySimulationService(VehicleStateService vehicleStateService) {
        this.vehicleStateService = vehicleStateService;
    }

    public TelemetryEvent generateTelemetry() {

        ConnectivityState connectivityState = new ConnectivityState(
                ConnectivityStatus.CONNECTED,
                82
        );

        EcuHealth ecuHealth = new EcuHealth(
                "TCU-001",
                EcuStatus.HEALTHY,
                8400,
                0
        );

        return new TelemetryEvent(
                Instant.now(),
                vehicleStateService.getCurrentState(),
                connectivityState,
                ecuHealth
        );
    }
}