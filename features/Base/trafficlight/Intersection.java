package trafficlight;

/**
 * This is the interface of the intersection your traffic light manages.
 * 
 * You have to provide your implementation in a subclass implementing this abstract class.
 * Do not edit this interface besides implementing the factory function!
 */
public abstract class Intersection {

	/**
	 * This method creates an instance of your intersection implementation.
	 * 
	 * It is called by the simulation to obtain the intersection.
	 * You have to modify this method to return an instance of your intersection class.
	 * 
	 * @return an instance of your intersection implementation.
	 */
	public static Intersection createIntersection() {
		return new IntersectionClass();
	}
	
	/**
	 * Enqueue a vehicle on the given road.
	 * 
	 * @param road the road where the vehicle gets enqueued.
	 */
	public abstract void enqueueVehicle(Road road);
	
	/**
	 * Advances the time of the simulation by one step.
	 */
	public abstract void advanceTime();
	
	/**
	 * Get the state of the traffic lights as a string.
	 * 
	 * The String is built as follows depending on the active features:
	 * - for each active direction, there is a substring:
	 *   * a single uppercase letter for the road (L, R, B, T)
	 *   * a uppercase V (for vehicles)
	 *   * a single lowercase letter for the traffic light color (r, o, g)
	 *   * the number of queued vehicles on this road
	 *   * ONLY IF PEDESTRIANS ARE ACTIVE:
	 *     a uppercase P (for pedestrians) followed by the number of queued
	 *     pedestrians on this road
	 * - the substrings for the roads must occur in the following order:
	 *       Left, Right, Bottom, Top
	 * - roads that are not included in the current configuration are left out
	 * - the remaining substrings are separated by a single space
	 * 
	 * For example, given the configuration {TL, Base, Left, Right, Top, Pedestrians, Timed}
	 * the initial state of the intersection is "LVg0Pr0 RVg0Pr0 TVr0Pg0".
	 * 
	 * @return
	 */
	public abstract String getIntersectionState();
}