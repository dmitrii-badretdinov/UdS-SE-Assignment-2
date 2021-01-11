package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.Intersection;
import trafficlight.Road;
import trafficlight.FeatureFlags;

public class OrangeTest{
	
	//TODO change the test to have orange
	@Test
	void Roads_PedestrianOrangeTimed_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		System.out.println("Orange and Timed test");
		
		sample.enqueueVehicle(Road.BOTTOM);
		sample.enqueuePedestrian(Road.BOTTOM);
		assertTrue(sample.getIntersectionState().contains("BVr1Pg1"));
		
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("BVr1Pg0"));
		for(int i = 0; i < 3; i++) {
			sample.enqueueVehicle(Road.BOTTOM);
			sample.enqueuePedestrian(Road.BOTTOM);
		}
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueuePedestrian(Road.LEFT);
		sample.enqueueVehicle(Road.RIGHT);
		sample.enqueuePedestrian(Road.RIGHT);
		sample.enqueueVehicle(Road.TOP);
		sample.enqueuePedestrian(Road.TOP);
		assertTrue(sample.getIntersectionState().contains("LVg1Pr1 RVg1Pr1 BVr4Pg3 TVr1Pg1"));
		
		for(int i = 0; i < 8; i++) {
			sample.advanceTime();
		}
		// Step 9
		assertTrue(sample.getIntersectionState().contains("LVg0Pr1 RVg0Pr1 BVr4Pg0 TVr1Pg0"));
		
		//10
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVo0Pr1 RVo0Pr1 BVr4Pg0 TVr1Pg0"));
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueuePedestrian(Road.LEFT);
		sample.enqueueVehicle(Road.RIGHT);
		sample.enqueuePedestrian(Road.RIGHT);
		sample.enqueuePedestrian(Road.BOTTOM);
		sample.enqueuePedestrian(Road.TOP);
		assertTrue(sample.getIntersectionState().contains("LVo1Pr2 RVo1Pr2 BVr4Pg1 TVr1Pg1"));
		
		//11
		sample.advanceTime();
		sample.enqueuePedestrian(Road.BOTTOM);
		sample.enqueuePedestrian(Road.TOP);
		assertTrue(sample.getIntersectionState().contains("LVo1Pr1 RVo1Pr1 BVr4Pg1 TVr1Pg1"));
		
		//12
		sample.advanceTime();
		sample.enqueueVehicle(Road.LEFT);
		sample.enqueuePedestrian(Road.LEFT);
		sample.enqueueVehicle(Road.RIGHT);
		sample.enqueuePedestrian(Road.RIGHT);
		assertTrue(sample.getIntersectionState().contains("LVr2Pg1 RVr2Pg1 BVo4Pr1 TVo1Pr1"));
		
		//13
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVr2Pg0 RVr2Pg0 BVo4Pr1 TVo1Pr1"));
		
		//14
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVr2Pg0 RVr2Pg0 BVg3Pr1 TVg0Pr1"));
		
		//15
		sample.advanceTime();
		assertTrue(sample.getIntersectionState().contains("LVr2Pg0 RVr2Pg0 BVg2Pr1 TVg0Pr1"));
		
		for(int i = 0; i < 8; i++) {
			sample.advanceTime();
		}
		
		//23
		assertTrue(sample.getIntersectionState().contains("LVr2Pg0 RVr2Pg0 BVg0Pr1 TVg0Pr1"));
		
		//24
		assertTrue(sample.getIntersectionState().contains("LVr2Pg0 RVr2Pg0 BVo0Pr1 TVo0Pr1"));
		
		//25
		assertTrue(sample.getIntersectionState().contains("LVr2Pg0 RVr2Pg0 BVo0Pr1 TVo0Pr1"));
		
		//26
		assertTrue(sample.getIntersectionState().contains("LVo2Pr0 RVo2Pr0 BVr0Pg0 TVr0Pg0"));
		
		//27
		assertTrue(sample.getIntersectionState().contains("LVo2Pr0 RVo2Pr0 BVr0Pg0 TVr0Pg0"));
		
		//28
		assertTrue(sample.getIntersectionState().contains("LVg1Pr0 RVg1Pr0 BVr0Pg0 TVr0Pg0"));
		
		for(int i = 0; i < 5; i++) {
			sample.advanceTime();
		}
		assertTrue(sample.getIntersectionState().contains("LVg0Pr0 RVg0Pr0 BVr0Pg0 TVr0Pg0"));
	}
}