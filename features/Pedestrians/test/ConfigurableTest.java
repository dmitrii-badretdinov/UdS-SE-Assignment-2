package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class ConfigurableTest {
	
	private void enqueuePedestrians(Intersection sample) {
		sample.enqueuePedestrian(Road.LEFT);
		sample.enqueuePedestrian(Road.RIGHT);
	}
}