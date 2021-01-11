package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.Intersection;
import trafficlight.Road;
import trafficlight.FeatureFlags;

public class PedestrianTest{
	
	//Debug
	@Test
	void AllRoads_Timed_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		
		if(FeatureFlags.timedIsActive) {
			for(int i = 0; i < 3; i++) {
				sample.enqueueVehicle(Road.LEFT);
				sample.enqueuePedestrian(Road.LEFT);
			}
			assertTrue(sample.getIntersectionState().contains("LVg3Pr3"));
			
			for(int i = 0; i < 3; i++) {
				sample.advanceTime();
			}
			assertTrue(sample.getIntersectionState().contains("LVg0Pr3"));
			
			if(!FeatureFlags.orangeIsActive) {
				for(int i = 0; i < 7; i++) {
					sample.advanceTime();
				}
				assertTrue(sample.getIntersectionState().contains("LVr0Pg2"));
				
				for(int i = 0; i < 2; i++) {
					sample.advanceTime();
				}
				assertTrue(sample.getIntersectionState().contains("LVr0Pg0"));
				
				for(int i = 0; i < 3; i++) {
					sample.enqueueVehicle(Road.LEFT);
					sample.enqueueVehicle(Road.RIGHT);
					sample.enqueueVehicle(Road.BOTTOM);
					sample.enqueueVehicle(Road.TOP);
					
					sample.enqueuePedestrian(Road.LEFT);
					sample.enqueuePedestrian(Road.RIGHT);
					sample.enqueuePedestrian(Road.BOTTOM);
					sample.enqueuePedestrian(Road.TOP);
				}
				assertTrue(sample.getIntersectionState().contains("LVr3Pg3 RVr3Pg3 BVg3Pr3 TVg3Pr3"));
			}
		}
	}
	
	//Debug
	@Test
	void Bottom_enqueuePedestrian_HasBVr3Pg3() {
		Intersection sample = Intersection.createIntersection();
		for(int i = 0; i < 3; i++) {
			sample.enqueueVehicle(Road.BOTTOM);
			sample.enqueuePedestrian(Road.BOTTOM);
		}
		assertTrue(sample.getIntersectionState().contains("BVr3Pg3"));
	}
	
	//Debug
	@Test
	void Top_enqueuePedestrian_HasTVr3Pg3() {
		Intersection sample = Intersection.createIntersection();
			for(int i = 0; i < 3; i++) {
				sample.enqueueVehicle(Road.TOP);
				sample.enqueuePedestrian(Road.TOP);
			}
			assertTrue(sample.getIntersectionState().contains("TVr3Pg3"));
	}
	
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
		
		if(FeatureFlags.timedIsActive) {
			for(int i = 0; i < 3; i++) {
				sample.enqueueVehicle(Road.LEFT);
				sample.enqueuePedestrian(Road.LEFT);
			}
			assertTrue(sample.getIntersectionState().contains("LVg3Pr3"));
			
			for(int i = 0; i < 3; i++) {
				sample.advanceTime();
			}
			assertTrue(sample.getIntersectionState().contains("LVg0Pr3"));
			
			if(!FeatureFlags.orangeIsActive) {
				for(int i = 0; i < 7; i++) {
					sample.advanceTime();
				}
				assertTrue(sample.getIntersectionState().contains("LVr0Pg2"));
				
				for(int i = 0; i < 2; i++) {
					sample.advanceTime();
				}
				assertTrue(sample.getIntersectionState().contains("LVr0Pg0"));
			}
		}
	}
}