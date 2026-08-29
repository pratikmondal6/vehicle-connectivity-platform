package com.ovcvp.telematics.controller;

import com.ovcvp.telematics.domain.TelematicsCall;
import com.ovcvp.telematics.service.TelematicsCallService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calls")
public class CallController {

    private final TelematicsCallService telematicsCallService;

    public CallController(TelematicsCallService telematicsCallService) {
        this.telematicsCallService = telematicsCallService;
    }

    @GetMapping
    public TelematicsCall getCurrentCall() {
        return telematicsCallService.getCurrentCall();
    }

    @PostMapping("/ecall")
    public TelematicsCall startECall() {
        telematicsCallService.startECall();
        return telematicsCallService.getCurrentCall();
    }

    @PostMapping("/breakdown")
    public TelematicsCall startBreakdownCall() {
        telematicsCallService.startBreakdownCall();
        return telematicsCallService.getCurrentCall();
    }

    @PostMapping("/connect")
    public TelematicsCall connect() {
        telematicsCallService.connect();
        return telematicsCallService.getCurrentCall();
    }

    @PostMapping("/fail")
    public TelematicsCall fail() {
        telematicsCallService.fail();
        return telematicsCallService.getCurrentCall();
    }

    @PostMapping("/end")
    public TelematicsCall end() {
        telematicsCallService.end();
        return telematicsCallService.getCurrentCall();
    }

    @PostMapping("/reset")
    public TelematicsCall reset() {
        telematicsCallService.reset();
        return telematicsCallService.getCurrentCall();
    }
}