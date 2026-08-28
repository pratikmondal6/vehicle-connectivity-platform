package com.ovcvp.telematics.domain;

public class VehicleState {

    private String vehicleId;
    private double speedKph;
    private int batteryPercent;
    private double latitude;
    private double longitude;

    public VehicleState() {
    }

    public VehicleState(
            String vehicleId,
            double speedKph,
            int batteryPercent,
            double latitude,
            double longitude) {
        this.vehicleId = vehicleId;
        this.speedKph = speedKph;
        this.batteryPercent = batteryPercent;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public double getSpeedKph() {
        return speedKph;
    }

    public void setSpeedKph(double speedKph) {
        this.speedKph = speedKph;
    }

    public int getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(int batteryPercent) {
        this.batteryPercent = batteryPercent;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}