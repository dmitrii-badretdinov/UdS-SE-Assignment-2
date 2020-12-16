package trafficlight;

public abstract class Intersection {
	
	/**
	 * Enqueue a pedestrian on the given road.
	 * 
	 * @param road the road where the pedestrian gets enqueued.
	 */
	public abstract void enqueuePedestrian(Road road);
}