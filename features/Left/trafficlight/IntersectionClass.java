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
	
	private int leftVehicleCount;
}