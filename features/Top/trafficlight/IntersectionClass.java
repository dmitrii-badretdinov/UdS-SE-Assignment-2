package trafficlight;

import trafficlight.FeatureFlags;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		topVehicleCount = 0;
		topVehicleLight = VehicleLight.RED;
		FeatureFlags.topIsActive = true;
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.TOP) {
			topVehicleCount++;
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		original();
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return original(finishedLeftPart) + "TV" + topVehicleLight.toString() + topVehicleCount + pedestrianInfo(Road.TOP);
	}
	
	private void initiateChangingLights() {
		topVehicleLight = changeVehicleLight(topVehicleLight);
		original();
	}
	
	private void processVehicles() {
		if(topVehicleLight == VehicleLight.GREEN && topVehicleCount > 0) {
			topVehicleCount--;
		}
		original();
	}
	
	private int topVehicleCount;
	private VehicleLight topVehicleLight;
}