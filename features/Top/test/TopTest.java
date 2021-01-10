package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

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
}