package com.ovcvp.telematics.domain;

import java.time.Instant;

public class TelematicsCall {

    private CallType type;
    private CallStatus status;
    private Instant startedAt;

    public TelematicsCall() {
        this.status = CallStatus.IDLE;
    }

    public CallType getType() {
        return type;
    }

    public void setType(CallType type) {
        this.type = type;
    }

    public CallStatus getStatus() {
        return status;
    }

    public void setStatus(CallStatus status) {
        this.status = status;
    }

    public Instant getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(Instant startedAt) {
        this.startedAt = startedAt;
    }
}