package trafficlight;


public class Main {
	
	private static final String BOTTOM = "bottom";
	
	private Road parseRoad(String roadString) {
		if (roadString.equals(BOTTOM)) {
			return Road.BOTTOM;
		}
		return original(roadString);
	}
}