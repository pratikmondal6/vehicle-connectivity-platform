package com.ovcvp.telematics.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class UpdateBatteryRequest {

    @Min(0)
    @Max(100)
    private int batteryPercent;

    public UpdateBatteryRequest() {
    }

    public int getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(int batteryPercent) {
        this.batteryPercent = batteryPercent;
    }
}