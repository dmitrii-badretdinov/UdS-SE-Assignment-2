package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

import trafficlight.Intersection;
import trafficlight.Road;

public class RightTest{
	
	/*
	 * Has RV and 1 in the output.
	 */
	@Test
	void initializationCheck() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.RIGHT);
		System.out.print(sample.getIntersectionState());
		assertTrue(sample.getIntersectionState().contains("RV"));
		assertTrue(sample.getIntersectionState().contains("1"));
	}
}