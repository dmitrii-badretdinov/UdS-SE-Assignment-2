package trafficlight;

public class IntersectionClass 	
	extends Intersection {
	
	public IntersectionClass() {
		rightVehicleCount = 0;
		rightVehicleLight = VehicleLight.GREEN;
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.RIGHT) {
			rightVehicleCount++;
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		original();
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return original(finishedLeftPart) + "RV" + rightVehicleLight.toString() + rightVehicleCount + pedestrianInfo(Road.RIGHT) + " ";
	}

	private void initiateChangingLights() {
		rightVehicleLight = changeVehicleLight(rightVehicleLight);
		original();
	}
	
	private void processVehicles() {
		if(rightVehicleLight == VehicleLight.GREEN && rightVehicleCount > 0) {
			rightVehicleCount--;
		}
		original();
	}
	
	private int rightVehicleCount;
	private VehicleLight rightVehicleLight;
}