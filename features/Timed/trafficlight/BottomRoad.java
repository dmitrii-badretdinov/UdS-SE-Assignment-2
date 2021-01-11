package trafficlight;

public class BottomRoad {
	
	public BottomRoad() {
		pedestrianCount = 0;
		pedestrianLight = PedestrianLight.GREEN;
	}
	
	public void advanceTime() {
		processVehicle();
		processPedestrian();
	}
	
	public String getRoadState() {
		return "BV" + vehicleLight.toString() + vehicleCount + "P" + pedestrianLight.toString() + pedestrianCount;
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