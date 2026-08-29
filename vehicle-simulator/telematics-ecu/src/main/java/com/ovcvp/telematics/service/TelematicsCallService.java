package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.CallStatus;
import com.ovcvp.telematics.domain.CallType;
import com.ovcvp.telematics.domain.TelematicsCall;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TelematicsCallService {

    private final TelematicsCall currentCall;

    public TelematicsCallService() {
        this.currentCall = new TelematicsCall();
    }

    public TelematicsCall getCurrentCall() {
        return currentCall;
    }

    public void startECall() {
        startCall(CallType.ECALL);
    }

    public void startBreakdownCall() {
        startCall(CallType.BREAKDOWN_CALL);
    }

    private void startCall(CallType type) {
        currentCall.setType(type);
        currentCall.setStatus(CallStatus.INITIATED);
        currentCall.setStartedAt(Instant.now());
    }

    public void connect() {
        currentCall.setStatus(CallStatus.CONNECTED);
    }

    public void fail() {
        currentCall.setStatus(CallStatus.FAILED);
    }

    public void end() {
        currentCall.setStatus(CallStatus.ENDED);
    }

    public void reset() {
        currentCall.setType(null);
        currentCall.setStatus(CallStatus.IDLE);
        currentCall.setStartedAt(null);
    }
}