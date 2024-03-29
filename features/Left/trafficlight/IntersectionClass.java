package trafficlight;

import java.lang.IllegalArgumentException;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		leftRoad = new LeftRoad();
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.LEFT) {
			leftRoad.enqueueVehicle();;
		}
		else {
			original(road);
		}
	}
	
	public void advanceTime() {
		original();
		leftRoad.advanceTime();
	}
	
	public String getIntersectionState() {		
		return composeIntersectionStateOutput("").trim();
	}
	
	public void enqueuePedestrian(Road road) {
		if(road == Road.LEFT) {
			leftRoad.enqueuePedestrian();
		}
		else {
			throw new IllegalArgumentException("Cannot parse the road for a pedestrian.");
		}
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return finishedLeftPart + leftRoad.getRoadState() + " ";
	}
	
	private void initiateChangingLights() {
		leftRoad.changeLights();
	}
	
	private LeftRoad leftRoad;
}