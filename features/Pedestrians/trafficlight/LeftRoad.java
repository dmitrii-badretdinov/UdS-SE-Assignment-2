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
	
	public void changeLights() {
		changeVehicleLight();
		changePedestrianLight();
	}
	
	public void changePedestrianLight() {
		switch(pedestrianLight) {
		case RED: pedestrianLight = PedestrianLight.GREEN; break;
		case GREEN: pedestrianLight = PedestrianLight.RED; break;
		default: throw new IllegalArgumentException("The pedestrian light has the color that shouldn't exist.");
		}
	}
	
	private void processPedestrian() {
		if(pedestrianLight == PedestrianLight.GREEN && pedestrianCount > 0) {
			pedestrianCount--;
		}
	}

	private int pedestrianCount;
	private PedestrianLight pedestrianLight;
}