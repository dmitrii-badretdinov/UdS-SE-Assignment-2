package trafficlight;

import trafficlight.FeatureFlags;

public class IntersectionClass 	
	extends Intersection {
	
	public IntersectionClass() {
		
		leftPedestrianCount = 0;
		rightPedestrianCount = 0;
		bottomPedestrianCount = 0;
		topPedestrianCount = 0;
		
		leftPedestrianLight = PedestrianLight.RED;
		rightPedestrianLight = PedestrianLight.RED;
		bottomPedestrianLight = PedestrianLight.GREEN;
		topPedestrianLight = PedestrianLight.GREEN;
		
		FeatureFlags.pedestriansIsActive = true;
	}

	public void enqueuePedestrian(Road road) {
		switch(road) {
			case LEFT: leftPedestrianCount++; break;
			case RIGHT: rightPedestrianCount++; break;
			case BOTTOM: bottomPedestrianCount++; break;
			case TOP: topPedestrianCount++; break;
			default: throw new IllegalArgumentException("The road to insert a pedestrian could not be recognized.");
		}
	}
	
	private String pedestrianInfo(Road road) {
		switch(road) {
		case LEFT: return "P" + leftPedestrianLight.toString() + leftPedestrianCount;
		case RIGHT: return "P" + rightPedestrianLight.toString() + rightPedestrianCount;
		case BOTTOM: return "P" + bottomPedestrianLight.toString() + bottomPedestrianCount;
		case TOP: return "P" + topPedestrianLight.toString() + topPedestrianCount;
		default: throw new IllegalArgumentException("The road from which to report pedestrians could not be recognized.");
	}
	}
	
	private void changePedestrianLights() {
		
	}
	
	private enum PedestrianLight {
		RED,
		GREEN;
		
		@Override
		public String toString() {
			switch(this) {
				case RED: return "r";
				case GREEN: return "g";
				default: throw new IllegalArgumentException("The light has the color that shouldn't exist.");
			}
		}
	}
	
	private int leftPedestrianCount;
	private int rightPedestrianCount;
	private int bottomPedestrianCount;
	private int topPedestrianCount;
	
	private PedestrianLight leftPedestrianLight;
	private PedestrianLight rightPedestrianLight;
	private PedestrianLight bottomPedestrianLight;
	private PedestrianLight topPedestrianLight;
}