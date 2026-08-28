package com.ovcvp.telematics.controller;

import com.ovcvp.telematics.domain.TelemetryEvent;
import com.ovcvp.telematics.service.TelemetrySimulationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telemetry")
public class TelemetryController {

    private final TelemetrySimulationService telemetrySimulationService;

    public TelemetryController(TelemetrySimulationService telemetrySimulationService) {
        this.telemetrySimulationService = telemetrySimulationService;
    }

    @GetMapping
    public TelemetryEvent getTelemetry() {
        return telemetrySimulationService.generateTelemetry();
    }
}