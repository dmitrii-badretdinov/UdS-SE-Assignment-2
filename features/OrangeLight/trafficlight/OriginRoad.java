package trafficlight;

public abstract class OriginRoad {
	
	protected OriginRoad() {
		isChangingLight = false;
	}
	
	public void advanceTime() {
		if(isChangingLight) {
			continueToChangeLight();
		}
		
		processVehicle();
	}
	
	private void continueToChangeLight() {
		
	}
	
	private void changeVehicleLight() {
		isChangingLight = true;
	}
	
	protected boolean isGreenToRed;
	private boolean isChangingLight;
}