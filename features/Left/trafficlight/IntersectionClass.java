package trafficlight;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		leftVehicleCount = 0;
		leftVehicleLight = VehicleLight.GREEN;
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.LEFT) {
			leftVehicleCount++;
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		
	}
	
	public String getIntersectionState() {		
		return composeIntersectionStateOutput("");
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return finishedLeftPart + "LV" + leftVehicleLight.toString() + leftVehicleCount + pedestrianInfo(Road.LEFT) + " ";
	}
	
	private String pedestrianInfo(Road road) {
		return "";
	}
	
	private VehicleLight changeVehicleLight(VehicleLight light) {
		switch(light) {
		case RED: return VehicleLight.GREEN;
		case GREEN: return VehicleLight.RED;
		default: throw new IllegalArgumentException("The light has the color that shouldn't exist.");
		}
	}
	
	private void initiateChangingLights() {
		leftVehicleLight = changeVehicleLight(leftVehicleLight);
	}
	
	private void processVehicles() {
		if(leftVehicleLight == VehicleLight.GREEN && leftVehicleCount > 0) {
			leftVehicleCount--;
		}
	}
	
	private int leftVehicleCount;
	private VehicleLight leftVehicleLight;
}