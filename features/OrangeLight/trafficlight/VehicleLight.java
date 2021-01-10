package trafficlight;

public enum VehicleLight {
	ORANGE;
	
	@Override
	public String toString() {
		switch(this) {
			case RED: return "r";
			case GREEN: return "g";
			case ORANGE: return "o";
			default: throw new IllegalArgumentException("The light has the color that shouldn't exist.");
		}
	}
}