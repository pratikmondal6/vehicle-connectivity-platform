package com.ovcvp.telematics.domain;

public class ConnectivityState {

    private ConnectivityStatus status;
    private int signalStrength;

    public ConnectivityState() {
    }

    public ConnectivityState(ConnectivityStatus status, int signalStrength) {
        this.status = status;
        this.signalStrength = signalStrength;
    }

    public ConnectivityStatus getStatus() {
        return status;
    }

    public void setStatus(ConnectivityStatus status) {
        this.status = status;
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    public void setSignalStrength(int signalStrength) {
        this.signalStrength = signalStrength;
    }
}