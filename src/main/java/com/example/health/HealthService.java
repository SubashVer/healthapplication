package com.example.health;

import com.example.health.Health;
import com.example.health.HealthRepository;

import com.example.health.Health;
import com.example.health.HealthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class HealthService {

	private HealthRepository repository;
	
	public HealthService(HealthRepository repository) {
		this.repository = repository;
	}
	
	public Health create(Health health) {
		return repository.save(health);
	}
	
	public Optional<Health> get(Integer healthId) {
		Optional<Health> optionalHealth = repository.findById(healthId);
		return optionalHealth;
	}
	
	 public List<Health> getAll() {
	        List<Health> healthy = null;
	       // try {
	            healthy = repository.findAll();
	       /* } catch (Exception e) {
	            System.out.println("STackTrace: " + Arrays.toString(e.getStackTrace()));
	            System.out.println("Caught an Exception....");
	            Healthy = new ArrayList<>();
	        }*/
	        return healthy;
	 }
	        public Health update(Integer healthId, Health health) {
	        if (healthId != health.getHealthId()) {
	            //throw new HealthValidationException("Mismatch in HealthId");
	        }
	        Optional<Health> healthOptional = repository.findById(healthId);
	        if (healthOptional.isPresent()) {
	            return repository.save(health);
	        }
	        else {
	            //throw new HealthNotFoundException("Employee Not found: " + healthId);
	        	return null;
	        }
}
	
}

	
