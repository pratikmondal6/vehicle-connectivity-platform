package com.ovcvp.telematics.domain;

import java.time.Instant;

public class TelemetryEvent {

    private Instant timestamp;
    private VehicleState vehicleState;
    private ConnectivityState connectivityState;
    private EcuHealth ecuHealth;

    public TelemetryEvent() {
    }

    public TelemetryEvent(
            Instant timestamp,
            VehicleState vehicleState,
            ConnectivityState connectivityState,
            EcuHealth ecuHealth) {
        this.timestamp = timestamp;
        this.vehicleState = vehicleState;
        this.connectivityState = connectivityState;
        this.ecuHealth = ecuHealth;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    public ConnectivityState getConnectivityState() {
        return connectivityState;
    }

    public void setConnectivityState(ConnectivityState connectivityState) {
        this.connectivityState = connectivityState;
    }

    public EcuHealth getEcuHealth() {
        return ecuHealth;
    }

    public void setEcuHealth(EcuHealth ecuHealth) {
        this.ecuHealth = ecuHealth;
    }
}