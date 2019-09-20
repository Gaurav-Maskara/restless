package com.consumer.beans;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthCheck extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		 // TODO implement some check
        boolean running = true;
        if (running) {
        	builder.up();
        } else {
        	builder.down();
        }
		
	}
  
	
}