package com.ovcvp.telematics.controller;

import com.ovcvp.telematics.domain.EcuLogEntry;
import com.ovcvp.telematics.service.EcuLogService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
public class EcuLogController {

    private final EcuLogService ecuLogService;

    public EcuLogController(EcuLogService ecuLogService) {
        this.ecuLogService = ecuLogService;
    }

    @GetMapping
    public EcuLogEntry getLog() {
        return ecuLogService.generateHeartbeatLog();
    }

    @GetMapping(
            value = "/serial",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getHeartbeatSerialOutput() {
        return ecuLogService.generateHeartbeatSerialOutput();
    }

    @GetMapping(
            value = "/serial/connectivity-lost",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getConnectivityLostSerialOutput() {
        return ecuLogService.generateConnectivityLostSerialOutput();
    }

    @GetMapping(
            value = "/serial/ecu-failure",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    public String getEcuFailureSerialOutput() {
        return ecuLogService.generateEcuFailureSerialOutput();
    }
}