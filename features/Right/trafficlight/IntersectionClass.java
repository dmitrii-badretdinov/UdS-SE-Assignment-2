package trafficlight;

public class IntersectionClass 	
	extends Intersection {
	
	public IntersectionClass() {
		rightRoad = new RightRoad();
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.RIGHT) {
			rightRoad.enqueueVehicle();
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		original();
		rightRoad.advanceTime();
	}
	
	public void enqueuePedestrian(Road road) {
		if(road == Road.RIGHT) {
			rightRoad.enqueuePedestrian();
		}
		else {
			original(road);
		}
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return original(finishedLeftPart) + rightRoad.getRoadState() + " ";
	}
	
	private void initiateChangingLights() {
		rightRoad.changeLights();
		original();
	}
	
	private RightRoad rightRoad;
}