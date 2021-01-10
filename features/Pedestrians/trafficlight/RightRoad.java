package trafficlight;

public class RightRoad {
	
	public RightRoad() {
		pedestrianCount = 0;
		pedestrianLight = PedestrianLight.RED;
	}
	
	public void advanceTime() {
		processVehicle();
		processPedestrian();
	}
	
	public String getRoadState() {
		return "RV" + vehicleLight.toString() + vehicleCount + "P" + pedestrianLight.toString() + pedestrianCount;
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