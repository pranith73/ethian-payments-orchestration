package com.ethian.webhook.controller.internal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/internal")
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "OK - webhook-service";
    }
}
