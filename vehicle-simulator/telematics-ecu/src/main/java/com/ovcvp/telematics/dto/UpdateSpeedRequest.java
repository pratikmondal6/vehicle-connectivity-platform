package com.ovcvp.telematics.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class UpdateSpeedRequest {

    @Min(0)
    @Max(300)
    private double speedKph;

    public UpdateSpeedRequest() {
    }

    public double getSpeedKph() {
        return speedKph;
    }

    public void setSpeedKph(double speedKph) {
        this.speedKph = speedKph;
    }
}