package com.ovcvp.telematics.service;

import com.ovcvp.telematics.domain.EcuHealth;
import com.ovcvp.telematics.domain.EcuStatus;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.Instant;

@Service
public class EcuHealthService {

    private final EcuHealth ecuHealth;
    private Instant startedAt;

    public EcuHealthService() {
        this.ecuHealth = new EcuHealth(
                "TCU-001",
                EcuStatus.HEALTHY,
                0,
                0
        );

        this.startedAt = Instant.now();
    }

    public EcuHealth getCurrentState() {
        updateUptime();
        return ecuHealth;
    }

    public void fail() {
        updateUptime();
        ecuHealth.setStatus(EcuStatus.FAILED);
    }

    public void degrade() {
        updateUptime();
        ecuHealth.setStatus(EcuStatus.DEGRADED);
    }

    public void restart() {
        ecuHealth.setStatus(EcuStatus.RESTARTING);
        ecuHealth.setRestartCount(ecuHealth.getRestartCount() + 1);
        ecuHealth.setUptimeSeconds(0);
        startedAt = Instant.now();
    }

    public void recover() {
        ecuHealth.setStatus(EcuStatus.HEALTHY);
        startedAt = Instant.now();
        ecuHealth.setUptimeSeconds(0);
    }

    private void updateUptime() {
        long uptimeSeconds =
                Duration.between(startedAt, Instant.now()).getSeconds();

        ecuHealth.setUptimeSeconds(uptimeSeconds);
    }
}