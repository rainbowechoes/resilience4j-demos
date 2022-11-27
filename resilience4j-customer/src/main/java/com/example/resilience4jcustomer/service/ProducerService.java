package com.example.resilience4jcustomer.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProducerService {
    @Autowired
    private RestTemplate restTemplate;
    @CircuitBreaker(name = "producer", fallbackMethod = "fallbackIndex")
    public String index() {
        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("http://producer:8080", String.class);
        return forEntity.getBody();

    }


    public String fallbackIndex(Throwable t) {
        System.out.println(t.getMessage());
        return "producer is busy";
    }
}
