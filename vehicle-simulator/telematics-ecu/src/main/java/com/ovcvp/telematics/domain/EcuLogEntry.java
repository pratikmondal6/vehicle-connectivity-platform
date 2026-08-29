package com.ovcvp.telematics.domain;

import java.time.Instant;

public class EcuLogEntry {

    private Instant timestamp;
    private LogLevel level;
    private String ecuId;
    private String message;

    public EcuLogEntry() {
    }

    public EcuLogEntry(
            Instant timestamp,
            LogLevel level,
            String ecuId,
            String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.ecuId = ecuId;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getEcuId() {
        return ecuId;
    }

    public String getMessage() {
        return message;
    }
}