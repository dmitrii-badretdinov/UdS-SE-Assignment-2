package trafficlight;

public class LeftRoad {

	public LeftRoad() {
		vehicleCount = 0;
		vehicleLight = VehicleLight.GREEN;
	}
	
	public void enqueueVehicle() {
		vehicleCount++;
	}
	
	public void advanceTime() {
		processVehicle();
	}
	
	public String getRoadState() {
		return "LV" + vehicleLight.toString() + vehicleCount;
	}
	
	public void enqueuePedestrian() {
		
	}
	
	public void changeLights() {
		
	}
	
	private void changeVehicleLight() {

	}
	
	public void processVehicle() {
		if(vehicleLight == VehicleLight.GREEN && vehicleCount > 0) {
			vehicleCount--;
		}
	}
	
	private int vehicleCount;
	private VehicleLight vehicleLight;
}