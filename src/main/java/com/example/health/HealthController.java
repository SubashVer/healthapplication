package com.example.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequestMapping("/health")
@RestController
public class HealthController {

    private final HealthService healthService;
    private final RestTemplate restTemplate;

    @Autowired
    public HealthController(HealthService healthService, RestTemplate restTemplate) {
        this.healthService = healthService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Health> getHealth(@PathVariable("id") Integer healthId) {
        return healthService.get(healthId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Health updateHealth(@PathVariable("id") Integer healthId, @RequestBody Health health) {
        return healthService.update(healthId, health);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Health> getAll() {
        return healthService.getAll();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Health createHealth(@RequestBody Health health) {
        System.out.println("Received Health Record: " + health);

        // Save the health record
        Health createdHealth = healthService.create(health);
        System.out.println("Created Health Record: " + createdHealth);

        // Communicate with the Risk microservice to calculate risk
        String risk = restTemplate.getForObject("http://localhost:8080/risk", String.class);

        // Handle the returned risk as needed
        System.out.println("Calculated Risk: " + risk);

        return createdHealth;
    }
}
