package trafficlight;

import java.lang.IllegalArgumentException;

public abstract class OriginRoad {
	
	protected OriginRoad() {
		vehicleCount = 0;
	}
	
	public void enqueueVehicle() {
		vehicleCount++;
	}
	
	public void advanceTime() {
		processVehicle();
	}
	
	public String getRoadState() {
		return roadSpecificLetter + "V" + vehicleLight.toString() + vehicleCount;
	}
	
	public void enqueuePedestrian() {}
	
	protected void changeLights() {
		changeVehicleLight();
	}
	
	private void changeVehicleLight() {
		switch(vehicleLight) {
		case RED: vehicleLight = VehicleLight.GREEN; break;
		case GREEN: vehicleLight = VehicleLight.RED; break;
		default: throw new IllegalArgumentException("The vehicle light has the color that shouldn't exist.");
		}
	}
	
	private void processVehicle() {
		if(vehicleLight == VehicleLight.GREEN && vehicleCount > 0) {
			vehicleCount--;
		}
	}
	
	protected int vehicleCount;
	protected VehicleLight vehicleLight;
	protected String roadSpecificLetter;	
}