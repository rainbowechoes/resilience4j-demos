package com.example.resilience4jcustomer.service;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
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
        // return fallback result when producer throw exception by use spring rest template
        ResponseEntity<String> forEntity = this.restTemplate.getForEntity("http://producer:8080", String.class);
        return forEntity.getBody();

//        not return fallback when producer throw exception by use other http library
//        HttpRequest request = HttpRequest.get("http://producer:8080");
//        HttpResponse response = request.execute();
//        return response.body();

    }


    public String fallbackIndex(Throwable t) {
        System.out.println(t.getMessage());
        return "producer is busy";
    }
}
