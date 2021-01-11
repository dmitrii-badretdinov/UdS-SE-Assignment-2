package trafficlight;

public class LeftRoad {

	private void changeVehicleLight() {
		switch(vehicleLight) {
		case RED: vehicleLight = VehicleLight.GREEN; break;
		case GREEN: vehicleLight = VehicleLight.RED; break;
		default: throw new IllegalArgumentException("The light has the color that shouldn't exist.");
		}
	}
}