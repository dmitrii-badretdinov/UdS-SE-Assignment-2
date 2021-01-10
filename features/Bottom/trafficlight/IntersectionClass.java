package trafficlight;

import trafficlight.FeatureFlags;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		bottomVehicleCount = 0;
		bottomVehicleLight = VehicleLight.RED;
		FeatureFlags.bottomIsActive = true;
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.BOTTOM) {
			bottomVehicleCount++;
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		original();
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return original(finishedLeftPart) + "BV" + bottomVehicleLight.toString() + bottomVehicleCount + pedestrianInfo(Road.BOTTOM) + " ";
	}
	
	private void initiateChangingLights() {
		bottomVehicleLight = changeVehicleLight(bottomVehicleLight);
		original();
	}
	
	private void processVehicles() {
		if(bottomVehicleLight == VehicleLight.GREEN && bottomVehicleCount > 0) {
			bottomVehicleCount--;
		}
		original();
	}
	
	private int bottomVehicleCount;
	private VehicleLight bottomVehicleLight;
}