package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import trafficlight.Intersection;
import trafficlight.Road;
import trafficlight.FeatureFlags;

public class OrangeTest{
	
	@Test
	void Roads_enqueueVehicle_HasCorrectOutput() {
		if (FeatureFlags.timedIsActive && FeatureFlags.topIsActive && FeatureFlags.bottomIsActive) {
			System.out.println("Orange and Timed test");
			
			Intersection sample = Intersection.createIntersection();
			
			sample.enqueueVehicle(Road.BOTTOM);
			assertTrue(sample.getIntersectionState().contains("LVg1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueueVehicle(Road.LEFT);
			sample.enqueueVehicle(Road.RIGHT);
			sample.enqueueVehicle(Road.TOP);
			sample.enqueueVehicle(Road.TOP);
			sample.enqueueVehicle(Road.BOTTOM);
			assertTrue(sample.getIntersectionState().contains("LVg2"));
			assertTrue(sample.getIntersectionState().contains("RVg1"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg1"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr1"));
			assertTrue(sample.getIntersectionState().contains("TVr2"));
			
			for(int i = 0; i < 6; i++) {
				sample.advanceTime();
			}
			
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			assertTrue(sample.getIntersectionState().contains("BVg0"));
			assertTrue(sample.getIntersectionState().contains("TVg1"));
			
			sample.advanceTime();
			assertTrue(sample.getIntersectionState().contains("LVr0"));
			assertTrue(sample.getIntersectionState().contains("RVr0"));
			assertTrue(sample.getIntersectionState().contains("BVg0"));
			assertTrue(sample.getIntersectionState().contains("TVg0"));
			
			for(int i = 0; i < 9; i++) {
				sample.advanceTime();
			}
			
			assertTrue(sample.getIntersectionState().contains("LVg0"));
			assertTrue(sample.getIntersectionState().contains("RVg0"));
			assertTrue(sample.getIntersectionState().contains("BVr0"));
			assertTrue(sample.getIntersectionState().contains("TVr0"));
		}
	}
}