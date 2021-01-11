package trafficlight;

public abstract class OriginRoad {
	
	protected OriginRoad() {
		isChangingLight = false;
		transitionCounter = 0;
	}
	
	public void advanceTime() {
		if(isChangingLight) {
			continueToChangeLight();
		}
		
		processVehicle();
	}
	
	private void continueToChangeLight() {
		transitionCounter++;
		if (isGreenToRed) {
			switch(transitionCounter) {
			case 1: 
				vehicleLight = VehicleLight.ORANGE; 
				break;
			case 3: 
				vehicleLight = VehicleLight.RED;
				finalizeLightTransition();
				break;
			}
		} 
		else {
			switch(transitionCounter) {
			case 3: 
				vehicleLight = VehicleLight.ORANGE; 
				break;
			case 5: 
				vehicleLight = VehicleLight.GREEN;
				finalizeLightTransition();
				break;
			}
		}
	}
	
	private void finalizeLightTransition() {
		transitionCounter = 0;
		isGreenToRed = !isGreenToRed;
		isChangingLight = false;
	}
	
	private void changeVehicleLight() {
		isChangingLight = true;
	}
	
	protected boolean isGreenToRed;
	private boolean isChangingLight;
	private int transitionCounter;
}