package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.VehicleState;
import org.springframework.stereotype.Service;

@Service
public class VehicleStateService {

    private final VehicleState vehicleState;

    public VehicleStateService() {
        this.vehicleState = new VehicleState(
                "VEHICLE-001",
                0.0,
                100,
                48.7665,
                11.4258
        );
    }

    public VehicleState getCurrentState() {
        return vehicleState;
    }

    public void updateSpeed(double speedKph) {
        vehicleState.setSpeedKph(speedKph);
    }

    public void updateBattery(int batteryPercent) {
        vehicleState.setBatteryPercent(batteryPercent);
    }
}