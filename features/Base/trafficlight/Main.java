package trafficlight;

import java.lang.IllegalArgumentException;
import java.util.Scanner;


/**
 * The main class for the project.
 * 
 * The main function simply calls {@code Main#simulate().}
 */
public class Main {
	
	private static final String STEP = "step";
	private static final String STATE = "state";
	private static final String VEHICLE = "vehicle";
	
	/*
	 * Run simulation on intersection.
	 * 
	 * Read commands from stdin and print intersection state after each command.
	 */
	private void simulate() {
		Intersection intersection = Intersection.createIntersection();

		Scanner scanner = new Scanner(System.in);
		try {
		    while (scanner.hasNextLine()) {
			    handleInput(scanner.nextLine(), intersection);
		    }
		} finally {
			scanner.close();
		}
	}
	
	/*
	 * Handle input commands.
	 * 
	 * Commands:
	 * - step             -> advance simulation by one step
	 * - state            -> print the current intersection state
	 * - vehicle $road    -> enqueue vehicle on road
	 * 
	 * Note that the feature Pedestrian adds another command.
	 */
	private void handleInput(String input, Intersection intersection) {
		if (input.startsWith(VEHICLE)) {
			Road road = parseRoad(input.substring(VEHICLE.length()).trim());
			intersection.enqueueVehicle(road);
			return;
		}
		if (input.equals(STEP)) {
			intersection.advanceTime();
			return;
		}
		if (input.equals(STATE)) {
		    System.out.println(intersection.getIntersectionState());
			return;
		}
		throw new IllegalArgumentException("Cannot parse command: " + input);
	}
	
	private Road parseRoad(String roadString) {
		throw new IllegalArgumentException("Cannot parse road: " + roadString);
	}
	
	public static void main(String[] args) {
		new Main().simulate();
	}
}