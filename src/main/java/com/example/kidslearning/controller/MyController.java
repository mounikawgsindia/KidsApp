package com.example.kidslearning.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/test")
    public String testEndpoint() {
        logger.info("Test endpoint hit!");
        return "Hello";
    }
}
