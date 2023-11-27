package com.example.health;

import com.example.health.Health;
import com.example.health.HealthService;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/health")
@RestController
public class HealthController {
	private HealthService service;

    public HealthController(HealthService service) {
        this.service = service;
    }
    
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Health> getHealth(@PathVariable("id") Integer healthId) {
        return service.get(healthId);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Health updateHealth(@PathVariable("id") Integer healthId, @RequestBody Health health) {
        return service.update(healthId, health);
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Health> getAll() {
        return service.getAll();
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Health createHealth(@RequestBody Health health) {
        Health createdHealth = service.create(health);
        return createdHealth;
    }

}
