package trafficlight;

public class IntersectionClass 	
	extends Intersection {
	
	public IntersectionClass() {
		bottomRoad = new BottomRoad();
		FeatureFlags.bottomIsActive = true;
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.BOTTOM) {
			bottomRoad.enqueueVehicle();
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		bottomRoad.advanceTime();
		original();
	}
	
	public void enqueuePedestrian(Road road) {
		if(road == Road.BOTTOM) {
			bottomRoad.enqueuePedestrian();
		}
		else {
			original(road);
		}
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return original(finishedLeftPart) + bottomRoad.getRoadState() + " ";
	}
	
	private void initiateChangingLights() {
		bottomRoad.changeLights();
		original();
	}
	
	private BottomRoad bottomRoad;
}