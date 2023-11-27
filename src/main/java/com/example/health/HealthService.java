package com.example.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HealthService {

    private final HealthRepository healthRepository;

    @Autowired
    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    public Health create(Health health) {
        return healthRepository.save(health);
    }

    public Optional<Health> get(Integer healthId) {
        return healthRepository.findById(healthId);
    }

    public Health update(Integer healthId, Health health) {
        if (!healthId.equals(health.getId())) {
            // Handle validation error
        }

        Optional<Health> existingHealth = healthRepository.findById(healthId);
        if (existingHealth.isPresent()) {
            return healthRepository.save(health);
        } else {
            // Handle not found error
            return null;
        }
    }

    public List<Health> getAll() {
        return healthRepository.findAll();
    }
}
