package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.Intersection;
import trafficlight.Road;
import trafficlight.FeatureFlags;

public class PedestrianTest{

	@Test
	void Left_enqueuePedestrian_HasLVg3Pr3() {
		Intersection sample = Intersection.createIntersection();
		for(int i = 0; i < 3; i++) {
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueuePedestrian(Road.LEFT);
		}
		System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Left pedestrians:", sample.getIntersectionState());
		assertTrue(sample.getIntersectionState().contains("LVg3Pr3"));
	}
	
	@Test
	void Right_enqueuePedestrian_HasRVg3Pr3() {
		Intersection sample = Intersection.createIntersection();
		for(int i = 0; i < 3; i++) {
			sample.enqueueVehicle(Road.RIGHT);
			sample.enqueuePedestrian(Road.RIGHT);
		}
		System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Right pedestrians:", sample.getIntersectionState());
		assertTrue(sample.getIntersectionState().contains("RVg3Pr3"));
	}
	
	@Test
	void Bottom_enqueuePedestrian_HasBVr3Pg3() {
		Intersection sample = Intersection.createIntersection();
		if (FeatureFlags.bottomIsActive) {
			for(int i = 0; i < 3; i++) {
				sample.enqueueVehicle(Road.BOTTOM);
				sample.enqueuePedestrian(Road.BOTTOM);
			}
			System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Bottom pedestrians:", sample.getIntersectionState());
			assertTrue(sample.getIntersectionState().contains("BVr3Pg3"));
		}
	}

	@Test
	void Top_enqueuePedestrian_HasTVr3Pg3() {
		Intersection sample = Intersection.createIntersection();
		if (FeatureFlags.topIsActive) {
			for(int i = 0; i < 3; i++) {
				sample.enqueueVehicle(Road.TOP);
				sample.enqueuePedestrian(Road.TOP);
			}
			System.out.format(OutputSettings.testNameFormat + OutputSettings.testResultFormat + "\n", "Top pedestrians:", sample.getIntersectionState());
			assertTrue(sample.getIntersectionState().contains("TVr3Pg3"));
		}
	}
}