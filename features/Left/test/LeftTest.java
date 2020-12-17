package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

import trafficlight.Intersection;
import trafficlight.Road;

public class LeftTest{
	
	/*
	 * Has LV and 1 in the output.
	 */
	@Test
	void initializationCheck() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.LEFT);
		assertTrue(sample.getIntersectionState().contains("LV"));
		assertTrue(sample.getIntersectionState().contains("1"));
	}
}