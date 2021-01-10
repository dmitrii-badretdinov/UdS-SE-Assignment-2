package trafficlight;

import trafficlight.FeatureFlags;

public class IntersectionClass 	
	extends Intersection {

	public IntersectionClass() {
		FeatureFlags.pedestriansIsActive = true;
	}
	
}