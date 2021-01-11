package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

import trafficlight.FeatureFlags;
import trafficlight.Intersection;
import trafficlight.Road;

public class BottomTest{
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
		}
	}
}