package com.ovcvp.telematics;
import com.ovcvp.telematics.domain.CallStatus;
import com.ovcvp.telematics.domain.CallType;
import com.ovcvp.telematics.service.TelematicsCallService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TelematicsCallServiceTest {

    @Test
    void shouldSimulateECallLifecycle() {

        TelematicsCallService service = new TelematicsCallService();

        service.startECall();

        assertEquals(CallType.ECALL, service.getCurrentCall().getType());
        assertEquals(CallStatus.INITIATED, service.getCurrentCall().getStatus());

        service.connect();

        assertEquals(CallStatus.CONNECTED, service.getCurrentCall().getStatus());

        service.end();

        assertEquals(CallStatus.ENDED, service.getCurrentCall().getStatus());
    }

    @Test
    void shouldSimulateFailedBreakdownCall() {

        TelematicsCallService service = new TelematicsCallService();

        service.startBreakdownCall();
        service.fail();

        assertEquals(
                CallType.BREAKDOWN_CALL,
                service.getCurrentCall().getType()
        );

        assertEquals(
                CallStatus.FAILED,
                service.getCurrentCall().getStatus()
        );
    }
}