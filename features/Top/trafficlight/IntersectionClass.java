package trafficlight;

public class IntersectionClass 	
	extends Intersection {
	
	public IntersectionClass() {
		topRoad = new TopRoad();
		FeatureFlags.topIsActive = true;
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.TOP) {
			topRoad.enqueueVehicle();
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		original();
		topRoad.advanceTime();
	}
	
	public void enqueuePedestrian(Road road) {
		if(road == Road.TOP) {
			topRoad.enqueuePedestrian();
		}
		else {
			original(road);
		}
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return original(finishedLeftPart) + topRoad.getRoadState() + " ";
	}
	
	private void initiateChangingLights() {
		topRoad.changeLights();
		original();
	}
	
	private TopRoad topRoad;
}