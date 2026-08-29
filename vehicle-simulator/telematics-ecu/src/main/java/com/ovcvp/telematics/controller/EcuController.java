package com.ovcvp.telematics.controller;

/**
 * Project: telematics-ecu
 * Author: Pratik Mondal
 * Created: 8/29/2026 12:57 PM
 */
import com.ovcvp.telematics.domain.EcuHealth;
import com.ovcvp.telematics.service.EcuHealthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ecu")
public class EcuController {

    private final EcuHealthService ecuHealthService;

    public EcuController(EcuHealthService ecuHealthService) {
        this.ecuHealthService = ecuHealthService;
    }

    @GetMapping
    public EcuHealth getEcuHealth() {
        return ecuHealthService.getCurrentState();
    }

    @PostMapping("/degrade")
    public EcuHealth degrade() {
        ecuHealthService.degrade();
        return ecuHealthService.getCurrentState();
    }

    @PostMapping("/fail")
    public EcuHealth fail() {
        ecuHealthService.fail();
        return ecuHealthService.getCurrentState();
    }

    @PostMapping("/restart")
    public EcuHealth restart() {
        ecuHealthService.restart();
        return ecuHealthService.getCurrentState();
    }

    @PostMapping("/recover")
    public EcuHealth recover() {
        ecuHealthService.recover();
        return ecuHealthService.getCurrentState();
    }
}