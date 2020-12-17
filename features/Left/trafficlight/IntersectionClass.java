package trafficlight;

/**
 * TODO description
 */
public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		leftVehicleCount = 0;
	}
	
	public String getIntersectionState() {
		String output = "";
		
		output += "LV";
		
		return output;
	}
	
	private String composeIntersectionStateOutput(String finishedLeftPart) {
		finishedLeftPart += "LV";
		
		return original(finishedLeftPart);
	}
	
	private int leftVehicleCount;
}