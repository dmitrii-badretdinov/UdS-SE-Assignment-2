package trafficlight;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		delayCounter = 0;
		delay = false;
		FeatureFlags.orangeIsActive = true;
	}
	
	private void strategyTickWithDelay() {
		if(delay) {
			delayCounter++;
			if (delayCounter == 4) {
				delay = false;
				delayCounter = 0;
			}
		}
		else {
			delay = strategyTick();
		}
	}
	
	private int delayCounter;
	private boolean delay;
}