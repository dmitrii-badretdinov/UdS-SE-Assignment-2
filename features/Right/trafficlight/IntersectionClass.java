package trafficlight;

/**
 * TODO description
 */
public class IntersectionClass 	
	extends Intersection {
	
	public IntersectionClass() {
		rightVehicleCount = 0;
	}
	
	public void enqueueVehicle(Road road) {
		if(road == Road.RIGHT) {
			rightVehicleCount++;
		}
		else {
			original(road);
		}
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		return original(finishedLeftPart) + "RV" + rightVehicleCount;
	}
	
	private int rightVehicleCount;
}