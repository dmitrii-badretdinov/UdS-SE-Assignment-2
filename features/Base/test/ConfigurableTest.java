package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class ConfigurableTest {
	
	@Test
	void theTest () {
		Intersection sample = Intersection.createIntersection();
		
		sample.enqueueVehicle(Road.LEFT);
		assertTrue(sample.getIntersectionState().contains("LVg1"));
		
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueueVehicle(Road.RIGHT);
		
		insertAnOptionalRoad(sample);
		
		assertTrue(sample.getIntersectionState().contains("LVg2"));
		assertTrue(sample.getIntersectionState().contains("RVg1"));
		
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVg1"));
		assertTrue(sample.getIntersectionState().contains("RVg0"));
		
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		assertTrue(sample.getIntersectionState().contains("RVg0"));
		
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		assertTrue(sample.getIntersectionState().contains("RVg0"));
		
		fastForward(sample);
		
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		assertTrue(sample.getIntersectionState().contains("RVg0"));
		
		enqueuePedestrians(sample);
		fastForward(sample);
		
	}
	
	private void insertAnOptionalRoad(Intersection sample) {}
	
	private void enqueuePedestrians(Intersection sample) {}
	
	private void fastForward(Intersection sample) {}
}