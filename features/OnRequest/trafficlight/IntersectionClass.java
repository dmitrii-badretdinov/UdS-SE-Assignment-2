package trafficlight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		redPhaseLength = 10;
		FeatureFlags.onrequestIsActive = true;
	}
	
	private boolean strategyTick() {
		String roadState = getIntersectionState();
		
		if (redPhase) {
			redPhaseCounter++;
			if (redPhaseCounter == redPhaseLength) {
				redPhase = false;
				initiateChangingLights();
				return true;
			}
		}
		else {
			redPhaseCounter = 0;
		}
		
		if (roadState.contains("LVg")) {
			leftRightGreenCounter++;
			if (leftRightGreenCounter > 9 && checkForLRPedestriansAndTBVehicles(roadState)) {
	            initiateChangingLights();
	            redPhase = true;
	            return true;
			}
		}
		else {
			leftRightGreenCounter = 0;
		}
		
		return false;
		
	}
	
	private boolean checkForLRPedestriansAndTBVehicles(String roadState) {
		foundSomething = false;
		for(int i = 0; i < 4; i++) {
			Matcher m = lightChangePatternsArray[i].matcher(roadState);
			if(m.find()) {
				foundSomething = true;
				if(!m.group(1).equals("0")) {
					return true;
				}
			}
		}
		if(!foundSomething) {
			System.out.println("OnDemand error. The output cannot contain none of the patterns.");
		}
		return false;
	}
	
	private int leftRightGreenCounter = 0;
	private int redPhaseCounter = 0;
	private boolean redPhase = false;
	private boolean foundSomething;
	private int redPhaseLength;
	private static final Pattern leftPedestriansPattern = Pattern.compile("L\\w+Pr(\\d+)");
	private static final Pattern rightPedestriansPattern = Pattern.compile("R\\w+Pr(\\d+)");
	private static final Pattern bottomVehiclesPattern = Pattern.compile("BVr(\\d+)");
	private static final Pattern topVehiclesPattern = Pattern.compile("TVr(\\d+)");
	private static final Pattern[] lightChangePatternsArray = new Pattern[] {leftPedestriansPattern, rightPedestriansPattern, bottomVehiclesPattern, topVehiclesPattern};
}