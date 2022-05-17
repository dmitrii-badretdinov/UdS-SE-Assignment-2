package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class ConfigurableTest {
	
	private void insertAnOptionalRoad(Intersection sample) {
		sample.enqueueVehicle(Road.BOTTOM);
	}
}