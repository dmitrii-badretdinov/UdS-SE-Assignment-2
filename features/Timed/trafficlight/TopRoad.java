package trafficlight;

public class TopRoad {
	
	public TopRoad() {
		pedestrianCount = 0;
		pedestrianLight = PedestrianLight.GREEN;
	}
	
	public void advanceTime() {
		processVehicle();
		processPedestrian();
	}
	
	public String getRoadState() {
		return "TV" + vehicleLight.toString() + vehicleCount + "P" + pedestrianLight.toString() + pedestrianCount;
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