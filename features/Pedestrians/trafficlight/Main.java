package trafficlight;


public class Main {
	
	private static final String PEDESTRIAN = "pedestrian";

	/*
	 * Handle input commands.
	 * 
	 * Additional commands:
	 * - pedestrian $road -> enqueue pedestrian on road
	 */
	private void handleInput(String input, Intersection intersection) {
		if (input.startsWith(PEDESTRIAN)) {
			Road road = parseRoad(input.substring(PEDESTRIAN.length()).trim());
			intersection.enqueuePedestrian(road);
			return;
		}
		original(input, intersection);
	}
}