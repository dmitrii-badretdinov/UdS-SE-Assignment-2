package test;


import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class TopTest{
	@Test
	void composeIntersectionStateOutput_createIntersection_HasTVr0() {
		Intersection sample = Intersection.createIntersection();
		System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Top basic:", sample.getIntersectionState());
		assertTrue(sample.getIntersectionState().contains("TVr0"));
	}
	
	@Test
	void composeIntersectionStateOutput_enqueueVehicle_HasTVr3() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.TOP);
		sample.enqueueVehicle(Road.TOP);
		sample.enqueueVehicle(Road.TOP);
		System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Top vehicles:", sample.getIntersectionState());
		assertTrue(sample.getIntersectionState().contains("TVr3"));
	}
	
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
			
			for(int i = 0; i < 6; i++) {
				sample.advanceTime();
			}
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			assertTrue(sample.getIntersectionState().contains("TVg1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			assertTrue(sample.getIntersectionState().contains("TVg0"));
			
			for(int i = 0; i < 9; i++) {
				sample.advanceTime();
			}
			
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("TVr0"));
		}
	}
}