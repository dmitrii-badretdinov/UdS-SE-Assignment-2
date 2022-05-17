package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class ConfigurableTest {
	
	private void fastForward(Intersection sample) {
		for(int i = 0; i < 43; i++) {
			sample.advanceTime();
		}
	}
}