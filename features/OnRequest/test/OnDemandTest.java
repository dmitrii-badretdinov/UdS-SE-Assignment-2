package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.Intersection;
import trafficlight.Road;

public class OnDemandTest{
	@Test
	void OnDemand_Orange_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		assertTrue(sample.getIntersectionState().contains("LVg0"));
		/*
		for(int i = 0; i < 150; i++) {
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueueVehicle(Road.RIGHT);
			sample.enqueueVehicle(Road.BOTTOM);
			sample.enqueueVehicle(Road.TOP);
			
			sample.enqueuePedestrian(Road.LEFT);
			sample.enqueuePedestrian(Road.RIGHT);
			sample.enqueuePedestrian(Road.BOTTOM);
			sample.enqueuePedestrian(Road.TOP);
		}
		
		assertTrue(sample.getIntersectionState().contains("LVg150Pr150 RVg150Pr150 BVr150Pg150 TVr150Pg150"));
		
		for(int i = 0; i < 550; i++) {
			sample.advanceTime();
		}
		assertTrue(sample.getIntersectionState().contains("LVg0Pr0 RVg0Pr0 BVr0Pg0 TVr0Pg0"));*/
	}
}