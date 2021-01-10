package trafficlight;

import trafficlight.FeatureFlags;

public class LeftRoad {
	
	public LeftRoad() {
		pedestrianCount = 0;
		pedestrianLight = PedestrianLight.RED;
		
		FeatureFlags.pedestriansIsActive = true;
	}
	
	public void advanceTime() {
		processVehicle();
		processPedestrian();
	}
	
	public String getRoadState() {
		return "LV" + vehicleLight.toString() + vehicleCount + "P" + pedestrianLight.toString() + pedestrianCount;
	}
	
	public void enqueuePedestrian() {
		pedestrianCount++;
	}
	
	private void processPedestrian() {
		if(pedestrianLight == PedestrianLight.GREEN && pedestrianCount > 0) {
			pedestrianCount--;
		}
	}

	private int pedestrianCount;
	private PedestrianLight pedestrianLight;
}