package com.example.resilience4jcustomer.controller;

import com.example.resilience4jcustomer.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ConsumerController {
    @Autowired
    private ProducerService producerService;

    @GetMapping
    public String index() {
        return this.producerService.index();
    }
}
