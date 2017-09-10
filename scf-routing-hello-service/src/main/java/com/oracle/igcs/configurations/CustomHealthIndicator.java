package com.oracle.igcs.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	private static int countRequests;

	@Value("${service.instance.name}")
	private String instance;

	
	@Override
	public Health health() {
		System.out.println("request handled by: " + instance);
		countRequests++;
		
		if(!instance.equals("instance-1")) {
			Health.up().withDetail("name", instance).build();
		} else {
			return (countRequests <= 3) ? Health.up().withDetail("name", instance).build()
					: Health.down().withDetail("name", instance).build(); 
		}
		return Health.up().build();
		
		
	}

}
