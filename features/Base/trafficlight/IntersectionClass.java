package trafficlight;

import java.lang.Exception;
import java.lang.IllegalArgumentException;

/**
 * The basic skeleton of an intersection class.
 */
public class IntersectionClass 	
	extends Intersection {
	
	public void enqueueVehicle(Road road) {
		throw new IllegalArgumentException("Cannot enqueue a vehicle on the road " + road);
	}
	
	public void advanceTime() {
		throw new Exception("Cannot advance time.");
	}
	
	public String getIntersectionState() {
		throw new Exception("Cannot get intersection.");
	}
	
	private enum VehicleLight {
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
}