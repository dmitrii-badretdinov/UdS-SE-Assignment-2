package test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;

public class DummyClass{
	
	private boolean checkForLRPedestriansAndTBVehicles(String roadState) {
		foundSomething = false;
		for(int i = 0; i < 4; i++) {
			Matcher m = lightChangePatternsArray[i].matcher(roadState);
			if(m.find()) {
				foundSomething = true;
				if(m.group(0) != "0") {
					return true;
				}
			}
		}
		if(!foundSomething) {
			System.out.println("OnDemand error. The output cannot contain none of the patterns.");
		}
		return false;
	}
	
	private boolean foundSomething;
	private static final Pattern leftPedestriansPattern = Pattern.compile("L\\w+Pg(\\d+)");
	private static final Pattern rightPedestriansPattern = Pattern.compile("R\\w+Pg(\\d+)");
	private static final Pattern bottomVehiclesPattern = Pattern.compile("BVr(\\d+)");
	private static final Pattern topVehiclesPattern = Pattern.compile("TVr(\\d+)");
	private static final Pattern[] lightChangePatternsArray = new Pattern[] {leftPedestriansPattern, rightPedestriansPattern, bottomVehiclesPattern, topVehiclesPattern};
	
	@Test
	void stringTest() {
		System.out.println(checkForLRPedestriansAndTBVehicles("LVg0Pr0 RVg0Pr0 BVr0Pg0 TVr0Pg0"));
	}
}