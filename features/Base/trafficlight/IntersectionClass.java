package trafficlight;

import java.lang.Exception;
import java.lang.IllegalArgumentException;

public class IntersectionClass 	
	extends Intersection {
	
	public void enqueueVehicle(Road road) {
		throw new IllegalArgumentException("Cannot enqueue a vehicle on the road " + road);
	}
	
	public void advanceTime() {
		strategyTickWithDelay();
	}
	
	private void strategyTickWithDelay() {
		strategyTick();
	}
	
	private boolean strategyTick() {
		return false;
	}
	
	public String getIntersectionState() {
		throw new Exception("Cannot get intersection.");
	}
}