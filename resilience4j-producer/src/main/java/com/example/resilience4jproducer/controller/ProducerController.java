package com.example.resilience4jproducer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/")
public class ProducerController {
    @GetMapping
    public String index() throws InterruptedException {
        return randomService();
    }

    public String randomService() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(100);
        int i = ThreadLocalRandom.current().nextInt(0, 4);
        if (i < 2) {
            throw new RuntimeException("random error");
        }

        return "producer ok";
    }

}
