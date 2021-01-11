package trafficlight;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		timeCounter = 0;
		FeatureFlags.timedIsActive = true;
	}
	
	private boolean strategyTick() {
		timeCounter++;
		if (timeCounter == 10) {
			timeCounter = 0;
			initiateChangingLights();
			return true;
		}
		return false;
	}
	
	private int timeCounter;
}