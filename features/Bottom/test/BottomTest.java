package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class BottomTest{	
	
	//Debug for LRB
	@Test
	void LRB_initialize_HasCorrectOutput() {
		Intersection sample = Intersection.createIntersection();
		
		if(!FeatureFlags.pedestriansIsActive && !FeatureFlags.topIsActive) {
			for(int i = 0; i < 3; i++) {
				sample.enqueueVehicle(Road.LEFT);
				sample.enqueueVehicle(Road.RIGHT);
				sample.enqueueVehicle(Road.BOTTOM);
			}
			assertTrue(sample.getIntersectionState().contains("LVr3"));
			assertTrue(sample.getIntersectionState().contains("RVr3"));
			assertTrue(sample.getIntersectionState().contains("BVr3"));
			assertTrue(!sample.getIntersectionState().contains("T"));
		}
	}
	
	//Debug for LRBPedestrian
	@Test
	void LRBPedestrian_initialize_HasCorrectOutput() {
		Intersection sample = Intersection.createIntersection();
		
		if(FeatureFlags.pedestriansIsActive && !FeatureFlags.topIsActive) {
			for(int i = 0; i < 3; i++) {
				sample.enqueueVehicle(Road.LEFT);
				sample.enqueueVehicle(Road.RIGHT);
				sample.enqueueVehicle(Road.BOTTOM);
				
				sample.enqueuePedestrian(Road.LEFT);
				sample.enqueuePedestrian(Road.RIGHT);
				sample.enqueuePedestrian(Road.BOTTOM);
			}
			assertTrue(sample.getIntersectionState().contains("LVr3Pr3"));
			assertTrue(sample.getIntersectionState().contains("RVr3Pr3"));
			assertTrue(sample.getIntersectionState().contains("BVr3Pg3"));
			assertTrue(!sample.getIntersectionState().contains("T"));
		}
	}
	
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
	
	@Test
	void Bottom_Timed_MultipleChecks() {
		Intersection sample = Intersection.createIntersection();
		if(FeatureFlags.timedIsActive) {
			sample.enqueueVehicle(Road.LEFT);
			assertTrue(sample.getIntersectionState().contains("LVg1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueueVehicle(Road.RIGHT);
			sample.enqueueVehicle(Road.BOTTOM);
			assertTrue(sample.getIntersectionState().contains("LVg2"));
			assertTrue(sample.getIntersectionState().contains("RVg1"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg1"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			
			for(int i = 0; i < 6; i++) {
				sample.advanceTime();
			}
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			assertTrue(sample.getIntersectionState().contains("BVg0"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			assertTrue(sample.getIntersectionState().contains("BVg0"));
			
			for(int i = 0; i < 9; i++) {
				sample.advanceTime();
			}
			
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr0"));
		}
	}
}