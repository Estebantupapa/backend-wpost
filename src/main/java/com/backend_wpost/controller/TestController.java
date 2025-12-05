package com.backend_wpost.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Backend WPost! API is working.";
    }

    @GetMapping("/status")
    public String status() {
        return "Status: OK - " + java.time.LocalDateTime.now();
    }
}