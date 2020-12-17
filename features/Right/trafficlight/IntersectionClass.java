package trafficlight;

/**
 * TODO description
 */
public class IntersectionClass 	
	extends Intersection {
	
	public IntersectionClass() {
		rightVehicleCount = 0;
	}

	public String getIntersectionState() {
		String output = "";
		
		output += "RV";
		
		return output;
	}
	
	private int rightVehicleCount;
}