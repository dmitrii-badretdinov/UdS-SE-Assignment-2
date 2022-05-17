package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import trafficlight.Intersection;
import trafficlight.Road;

public class BottomTest{

	@Test
	void composeIntersectionStateOutput_createIntersection_HasBVr0() {
		Intersection sample = Intersection.createIntersection();
		assertTrue(sample.getIntersectionState().contains("BVr0"));
	}
	
	@Test
	void composeIntersectionStateOutput_enqueueVehicle_HasBVr3() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.BOTTOM);
		sample.enqueueVehicle(Road.BOTTOM);
		sample.enqueueVehicle(Road.BOTTOM);
		assertTrue(sample.getIntersectionState().contains("BVr3"));
	}
	
	
}