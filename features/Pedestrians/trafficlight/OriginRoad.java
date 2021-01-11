package trafficlight;

public abstract class OriginRoad {
	
	protected OriginRoad() {
		pedestrianCount = 0;
	}
	
	public void advanceTime() {
		original();
		updatePedestrianLight();
		processPedestrian();
	}
	
	public String getRoadState() {
		return roadSpecificLetter + "V" + vehicleLight.toString() + vehicleCount + "P" + pedestrianLight.toString() + pedestrianCount;
	}
	
	public void enqueuePedestrian() {
		pedestrianCount++;
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