package com.ovcvp.telematics.service;

/**
 * Project: telematics-ecu
 * Author: Pratik Mondal
 * Created: 8/29/2026 12:55 PM
 */

import com.ovcvp.telematics.domain.EcuHealth;
import com.ovcvp.telematics.domain.EcuStatus;
import org.springframework.stereotype.Service;

@Service
public class EcuHealthService {

    private final EcuHealth ecuHealth;

    public EcuHealthService() {
        this.ecuHealth = new EcuHealth(
                "TCU-001",
                EcuStatus.HEALTHY,
                0,
                0
        );
    }

    public EcuHealth getCurrentState() {
        return ecuHealth;
    }

    public void fail() {
        ecuHealth.setStatus(EcuStatus.FAILED);
    }

    public void restart() {
        ecuHealth.setStatus(EcuStatus.RESTARTING);
        ecuHealth.setRestartCount(ecuHealth.getRestartCount() + 1);
        ecuHealth.setUptimeSeconds(0);
    }

    public void recover() {
        ecuHealth.setStatus(EcuStatus.HEALTHY);
    }

    public void degrade() {
        ecuHealth.setStatus(EcuStatus.DEGRADED);
    }
}