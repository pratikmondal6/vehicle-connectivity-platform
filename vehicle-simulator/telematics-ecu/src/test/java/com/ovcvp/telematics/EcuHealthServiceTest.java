package com.ovcvp.telematics;

import com.ovcvp.telematics.domain.EcuStatus;
import com.ovcvp.telematics.service.EcuHealthService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EcuHealthServiceTest {

    @Test
    void shouldFailRestartAndRecoverEcu() {

        EcuHealthService service = new EcuHealthService();

        service.fail();

        assertEquals(
                EcuStatus.FAILED,
                service.getCurrentState().getStatus()
        );

        service.restart();

        assertEquals(
                EcuStatus.RESTARTING,
                service.getCurrentState().getStatus()
        );

        assertEquals(
                1,
                service.getCurrentState().getRestartCount()
        );

        assertEquals(
                0,
                service.getCurrentState().getUptimeSeconds()
        );

        service.recover();

        assertEquals(
                EcuStatus.HEALTHY,
                service.getCurrentState().getStatus()
        );
    }
}