package com.ovcvp.telematics.domain;

public class EcuHealth {

    private String ecuId;
    private EcuStatus status;
    private long uptimeSeconds;
    private int restartCount;

    public EcuHealth() {
    }

    public EcuHealth(
            String ecuId,
            EcuStatus status,
            long uptimeSeconds,
            int restartCount) {
        this.ecuId = ecuId;
        this.status = status;
        this.uptimeSeconds = uptimeSeconds;
        this.restartCount = restartCount;
    }

    public String getEcuId() {
        return ecuId;
    }

    public void setEcuId(String ecuId) {
        this.ecuId = ecuId;
    }

    public EcuStatus getStatus() {
        return status;
    }

    public void setStatus(EcuStatus status) {
        this.status = status;
    }

    public long getUptimeSeconds() {
        return uptimeSeconds;
    }

    public void setUptimeSeconds(long uptimeSeconds) {
        this.uptimeSeconds = uptimeSeconds;
    }

    public int getRestartCount() {
        return restartCount;
    }

    public void setRestartCount(int restartCount) {
        this.restartCount = restartCount;
    }
}