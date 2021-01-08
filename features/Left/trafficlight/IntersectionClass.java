package trafficlight;

/**
 * TODO description
 */
public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		leftVehicleCount = 0;
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
		return finishedLeftPart + "LV" + leftVehicleCount;
	}
	
	private int leftVehicleCount;
}