package com.ovcvp.telematics.controller;

import com.ovcvp.telematics.domain.VehicleState;
import com.ovcvp.telematics.dto.UpdateSpeedRequest;
import com.ovcvp.telematics.service.VehicleStateService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vehicle")
public class VehicleController {

    private final VehicleStateService vehicleStateService;

    public VehicleController(VehicleStateService vehicleStateService) {
        this.vehicleStateService = vehicleStateService;
    }

    @GetMapping
    public VehicleState getVehicleState() {
        return vehicleStateService.getCurrentState();
    }

    @PostMapping("/speed")
    public VehicleState updateSpeed(
            @Valid @RequestBody UpdateSpeedRequest request) {

        vehicleStateService.updateSpeed(request.getSpeedKph());

        return vehicleStateService.getCurrentState();
    }
}