package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

import trafficlight.Intersection;
import trafficlight.Road;

public class RightTest{
	@Test
	void composeIntersectionStateOutput_createIntersection_HasRVg0() {
		Intersection sample = Intersection.createIntersection();
		assertTrue(sample.getIntersectionState().contains("RVg0"));
	}
	
	@Test
	void composeIntersectionStateOutput_enqueueVehicle_HasTVg3() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.RIGHT);
		sample.enqueueVehicle(Road.RIGHT);
		sample.enqueueVehicle(Road.RIGHT);
		assertTrue(sample.getIntersectionState().contains("RVg3"));
	}
}