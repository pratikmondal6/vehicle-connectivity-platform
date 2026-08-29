package com.ovcvp.telematics.controller;

import com.ovcvp.telematics.domain.ConnectivityState;
import com.ovcvp.telematics.service.ConnectivityStateService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/connectivity")
public class ConnectivityController {

    private final ConnectivityStateService connectivityStateService;

    public ConnectivityController(ConnectivityStateService connectivityStateService) {
        this.connectivityStateService = connectivityStateService;
    }

    @GetMapping
    public ConnectivityState getConnectivityState() {
        return connectivityStateService.getCurrentState();
    }

    @PostMapping("/connect")
    public ConnectivityState connect() {
        connectivityStateService.connect();
        return connectivityStateService.getCurrentState();
    }

    @PostMapping("/degrade")
    public ConnectivityState degrade() {
        connectivityStateService.degrade();
        return connectivityStateService.getCurrentState();
    }

    @PostMapping("/disconnect")
    public ConnectivityState disconnect() {
        connectivityStateService.disconnect();
        return connectivityStateService.getCurrentState();
    }
}