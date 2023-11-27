package com.example.health;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Health {
	@GeneratedValue(strategy = GenerationType.AUTO)
	
    @Id

    private Integer healthId;
    public Integer getHealthId() {
		return healthId;
	}
    
	public void setHealthId(Integer healthId) {
		this.healthId = healthId;
	}
	
	public String getHealthname() {
		return healthname;
	}
	
	public void setHealthname(String healthname) {
		this.healthname = healthname;
	}
	
	private String healthname;
}