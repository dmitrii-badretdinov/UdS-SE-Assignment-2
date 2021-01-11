package trafficlight;

public abstract class OriginRoad {
	
	protected OriginRoad() {
		vehicleCount = 0;
		pedestrianCount = 0;
	}
	
	public void advanceTime() {
		processPedestrian();
		original();
	}
	
	public String getRoadState() {
		return roadSpecificLetter + "V" + vehicleLight.toString() + vehicleCount + "P" + pedestrianLight.toString() + pedestrianCount;
	}
	
	public void enqueuePedestrian() {
		pedestrianCount++;
	}
	
	protected void changeLights() {
		original();
		updatePedestrianLight();
	}
	
	protected void updatePedestrianLight() {
		if (vehicleLight == VehicleLight.RED) {
			pedestrianLight = PedestrianLight.GREEN;
		}
		else {
			pedestrianLight = PedestrianLight.RED;
		}
	}
	
	private void processPedestrian() {
		if(pedestrianLight == PedestrianLight.GREEN && pedestrianCount > 0) {
			pedestrianCount--;
		}
	}
	
	protected int pedestrianCount;
	protected PedestrianLight pedestrianLight;
}