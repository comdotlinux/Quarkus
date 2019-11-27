package com.linux;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Readiness
@ApplicationScoped
public class CanShowerHealthCheck implements HealthCheck {

	@Inject
	@ConfigProperty(name = "healthy", defaultValue = "true")
	boolean healthy;


	@Override
	public HealthCheckResponse call() {
		return healthy ? HealthCheckResponse.up("Able to take a shower") : HealthCheckResponse.down("Cannot Shower right now...");
	}
}
