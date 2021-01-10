package trafficlight;

import trafficlight.FeatureFlags;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		timeCounter = 0;
		
		FeatureFlags.timedIsActive = true;
	}
	
	public void advanceTime() {
		timeCounter++;
		if (timeCounter == 10) {
			timeCounter = 0;
			initiateChangingLights();
		}
		original();
	}
	

	
	private int timeCounter;
}