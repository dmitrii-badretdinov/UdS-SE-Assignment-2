package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

import trafficlight.Intersection;
import trafficlight.Road;

public class BottomTest{	
	@Test
	void composeIntersectionStateOutput_createIntersection_HasBVr0() {
		Intersection sample = Intersection.createIntersection();
		System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Bottom basic:", sample.getIntersectionState());
		assertTrue(sample.getIntersectionState().contains("BVr0"));
	}
	
	@Test
	void composeIntersectionStateOutput_enqueueVehicle_HasBVr3() {
		Intersection sample = Intersection.createIntersection();
		sample.enqueueVehicle(Road.BOTTOM);
		sample.enqueueVehicle(Road.BOTTOM);
		sample.enqueueVehicle(Road.BOTTOM);
		System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Bottom vehicles:", sample.getIntersectionState());
		assertTrue(sample.getIntersectionState().contains("BVr3"));
	}
}