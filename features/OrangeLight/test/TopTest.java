package test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class TopTest{
	@Test
	void Top_Timed_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		if(FeatureFlags.timedIsActive) {
			
			sample.enqueueVehicle(Road.LEFT);
			assertTrue(sample.getIntersectionState().contains("LVg1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueueVehicle(Road.RIGHT);
			sample.enqueueVehicle(Road.TOP);
			sample.enqueueVehicle(Road.TOP);
			assertTrue(sample.getIntersectionState().contains("LVg2"));
			assertTrue(sample.getIntersectionState().contains("RVg1"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg1"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
		}
	}
}