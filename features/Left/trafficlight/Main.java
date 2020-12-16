package trafficlight;


public class Main {
	
	private static final String LEFT = "left";
	
	private Road parseRoad(String roadString) {
		if (roadString.equals(LEFT)) {
			return Road.LEFT;
		}
		return original(roadString);
	}
}