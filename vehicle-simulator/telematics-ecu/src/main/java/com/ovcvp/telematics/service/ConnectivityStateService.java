package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.ConnectivityState;
import com.ovcvp.telematics.domain.ConnectivityStatus;
import org.springframework.stereotype.Service;

@Service
public class ConnectivityStateService {

    private final ConnectivityState connectivityState;

    public ConnectivityStateService() {
        this.connectivityState = new ConnectivityState(
                ConnectivityStatus.CONNECTED,
                100
        );
    }

    public ConnectivityState getCurrentState() {
        return connectivityState;
    }

    public void connect() {
        connectivityState.setStatus(ConnectivityStatus.CONNECTED);
        connectivityState.setSignalStrength(100);
    }

    public void degrade() {
        connectivityState.setStatus(ConnectivityStatus.DEGRADED);
        connectivityState.setSignalStrength(40);
    }

    public void disconnect() {
        connectivityState.setStatus(ConnectivityStatus.DISCONNECTED);
        connectivityState.setSignalStrength(0);
    }
}