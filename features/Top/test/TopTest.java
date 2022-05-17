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
		assertTrue(sample.getIntersectionState().contains("TVr0"));
	}
	
	@Test
	void composeIntersectionStateOutput_enqueueVehicle_HasTVr3() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.TOP);
		sample.enqueueVehicle(Road.TOP);
		sample.enqueueVehicle(Road.TOP);
		assertTrue(sample.getIntersectionState().contains("TVr3"));
	}
}