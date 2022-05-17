package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class OnDemandTest{
	@Test
	void OnDemand_Orange_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		
		for(int i = 0; i < 150; i++) {
			sample.enqueueVehicle(Road.LEFT);
		}
		
		for(int i = 0; i < 150; i++) {
			sample.advanceTime();
		}
		
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		assertTrue(sample.getIntersectionState().contains("RVg0"));
		
	}
	
	@Test
	void OnDemand_NoOrange_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		if(!FeatureFlags.orangeIsActive) {
			
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			
			for(int i = 0; i < 150; i++) {
				sample.enqueueVehicle(Road.LEFT);
			}
			
			for(int i = 0; i < 150; i++) {
				sample.advanceTime();
			}
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
		}
	}
}