package com.aravinth.spring.boot.restful.SpringBootRest.Actuators;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class CustomeHealthIndicator implements HealthIndicator,InfoContributor{

	@Override
	public Health health() {
		boolean error = true;
		if(error) {
			return Health.down().withDetail("Error key",123).build();
		}
		return Health.up().build();
	}

	@Override
	public void contribute(Builder builder) {
		Map<String, String> details = new HashMap<>();
        details.put("bean-definition-count","1");
        details.put("startup-date","10-4-2022");
        builder.withDetail("context", details).build();
	}

}
