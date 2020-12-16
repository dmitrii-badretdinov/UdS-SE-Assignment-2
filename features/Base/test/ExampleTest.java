package test;

// import junit assertions
import static org.junit.jupiter.api.Assertions.assertTrue;

// import junit test annotation
import org.junit.jupiter.api.Test;

public class ExampleTest{
	
	/*
	 * A simple test case
	 */
	@Test
	void demoTestCase() {
		assertTrue(4 > 3);
	}
}