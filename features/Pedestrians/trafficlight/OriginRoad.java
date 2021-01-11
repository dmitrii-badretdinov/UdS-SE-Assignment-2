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
		changePedestrianLight();
		original();
	}
	
	protected void changePedestrianLight() {
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
	
	protected int pedestrianCount;
	protected PedestrianLight pedestrianLight;
}