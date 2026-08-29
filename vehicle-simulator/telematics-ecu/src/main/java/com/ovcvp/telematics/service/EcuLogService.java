package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.EcuLogEntry;
import com.ovcvp.telematics.domain.LogLevel;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class EcuLogService {

    public EcuLogEntry generateHeartbeatLog() {
        return new EcuLogEntry(
                Instant.now(),
                LogLevel.INFO,
                "TCU-001",
                "Telematics ECU heartbeat"
        );
    }

    public String generateHeartbeatSerialOutput() {
        return buildSerialOutput(
                LogLevel.INFO,
                "HEARTBEAT"
        );
    }

    public String generateConnectivityLostSerialOutput() {
        return buildSerialOutput(
                LogLevel.WARN,
                "CONNECTIVITY_LOST"
        );
    }

    public String generateEcuFailureSerialOutput() {
        return buildSerialOutput(
                LogLevel.ERROR,
                "ECU_FAILURE"
        );
    }

    private String buildSerialOutput(
            LogLevel level,
            String event
    ) {
        return String.format(
                "TS=%s|ECU=TCU-001|LEVEL=%s|EVENT=%s",
                Instant.now(),
                level,
                event
        );
    }
}