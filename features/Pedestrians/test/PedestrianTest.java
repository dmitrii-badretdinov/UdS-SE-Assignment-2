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
		assertTrue(sample.getIntersectionState().contains("LVg3Pr3"));
	}
	
	@Test
	void Right_enqueuePedestrian_HasRVg3Pr3() {
		Intersection sample = Intersection.createIntersection();
		for(int i = 0; i < 3; i++) {
			sample.enqueueVehicle(Road.RIGHT);
			sample.enqueuePedestrian(Road.RIGHT);
		}
		assertTrue(sample.getIntersectionState().contains("RVg3Pr3"));
	}
	
	@Test
	void Left_Timed_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		
		for(int i = 0; i < 3; i++) {
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueuePedestrian(Road.LEFT);
		}
		assertTrue(sample.getIntersectionState().contains("LVg3Pr3"));
		
		for(int i = 0; i < 3; i++) {
			sample.advanceTime();
		}
		assertTrue(sample.getIntersectionState().contains("LVg0Pr3"));
		
	}
}