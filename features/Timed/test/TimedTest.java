package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.Intersection;
import trafficlight.Road;
import trafficlight.FeatureFlags;

public class TimedTest{

	@Test
	void Roads_enqueueVehicle_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		
		sample.enqueueVehicle(Road.LEFT);
		assertTrue(sample.getIntersectionState().contains("LVg1"));
		
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueueVehicle(Road.RIGHT);
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
		
		if(!FeatureFlags.orangeIsActive) {
			for(int i = 0; i < 6; i++) {
				sample.advanceTime();
			}
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			
			for(int i = 0; i < 9; i++) {
				sample.advanceTime();
			}
			
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
		}
	}
}