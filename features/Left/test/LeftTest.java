package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

import trafficlight.Intersection;
import trafficlight.Road;

public class LeftTest{
	@Test
	void composeIntersectionStateOutput_createIntersection_HasLVg0() {
		Intersection sample = Intersection.createIntersection();
		assertTrue(sample.getIntersectionState().contains("LVg0"));
	}
	
	@Test
	void composeIntersectionStateOutput_enqueueVehicle_HasLVg3() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueueVehicle(Road.LEFT);
		assertTrue(sample.getIntersectionState().contains("LVg3"));
	}
}