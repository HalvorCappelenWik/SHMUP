package shmup;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.javajunkies.Vector2;

public class Vector2Test {
	Vector2 vector;
	Vector2 vector2;
	Vector2 vectorParalellToVector;
	double scalar;
	double angle;
	
	private boolean almostEqual(double a, double b) {
		return Math.abs(a - b) < 0.02;
	}
	
	@Before
	public void setup() {
		vector = new Vector2(4,8);
		vector2 = new Vector2(5, 0.5);
		vectorParalellToVector = new Vector2(8,16);
		scalar = 5.7;
		angle = 40;
	}
	
	@Test
	public void equalsTest() {
		Vector2 equalVector = new Vector2(4,8);
		assertTrue(vector.equals(equalVector));
	}
	
	@Test
	public void lengthTest() {
		assertTrue(almostEqual(vector.length(), 8.94));
		assertTrue(almostEqual(vector2.length(), 5.02));
		assertTrue(almostEqual(vectorParalellToVector.length(), 17.89));
	}
	
	@Test
	public void addTest() {
		vector.add(vector2);
		assertTrue(vector.equals(new Vector2(9,8.5)));
	}
	
	@Test
	public void subtractTest() {
		vector.subtract(vector2);
		assertTrue(vector.equals(new Vector2(-1, 7.5)));
	}
	
	@Test
	public void multiplyScalarTest() {
		vector.multiply(scalar);
		assertTrue(vector.equals(new Vector2(22.8, 45.6)));
	}
	
	@Test
	public void multiplyVectorTest() {
		double result = Vector2.multiply(vector, vector2);
		assertTrue(result == 24);
	}
	
	@Test
	public void normalizeTest() {
		vector.normalize();
		assertTrue(vector.getX() <= 1);
		assertTrue(vector.getY() <= 1);
		assertTrue(almostEqual(vector.length(), 1));
		assertTrue(almostEqual(vector.getX(), 0.4472135954999579));
		assertTrue(almostEqual(vector.getY(), 0.8944271909999159));
	}
	
	@Test
	public void angleTest() {
		
	}
}
