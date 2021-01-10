package trafficlight;

public enum VehicleLight {
	RED,
	GREEN;
	
	@Override
	public String toString() {
		switch(this) {
			case RED: return "r";
			case GREEN: return "g";
			default: throw new IllegalArgumentException("The light has the color that shouldn't exist.");
		}
	}
}