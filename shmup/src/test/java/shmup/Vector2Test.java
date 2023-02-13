package shmup;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.javajunkies.Vector2;

public class Vector2Test {
	private boolean almostEqual(double a, double b) {
		return Math.abs(a - b) < 0.02;
	}
	
	@Test
	public void equalsTest() {
		Vector2 a = new Vector2(4, 8);
		Vector2 b = new Vector2(4, 8);
		assertTrue(a.equals(b));
	}
	
	@Test
	public void lengthTest() {
		assertTrue(almostEqual(new Vector2(3, 4).length(), 5));
		assertTrue(almostEqual(new Vector2(4, 8).length(), 8.94));
		assertTrue(almostEqual(new Vector2(5, 0.5).length(), 5.02));
		assertTrue(almostEqual(new Vector2(8, 16).length(), 17.89));
	}
	
	@Test
	public void addTest() {
		Vector2 v = new Vector2(2, 5);
		v.add(new Vector2(-4, 1));
		
		assertTrue(v.equals(new Vector2(-2,6)));
	}
	
	@Test
	public void subtractTest() {
		Vector2 v = new Vector2(1, 2);
		v.subtract(new Vector2(2, 1));
		
		assertTrue(v.equals(new Vector2(-1, 1)));
	}
	
	@Test
	public void multiplyScalarTest() {
		Vector2 v = new Vector2(1, 2);
		v.multiply(5);

		assertTrue(v.equals(new Vector2(5, 10)));
	}
	
	@Test
	public void dotProductTest() {
		Vector2 a = new Vector2(4, 8);
		Vector2 b = new Vector2(5, 0.5);

		assertTrue(Vector2.dot(a, b) == 24);
	}
	
	@Test
	public void normalizeTest() {
		Vector2 vector = new Vector2(4, 8);
		vector.normalize();
		assertTrue(vector.getX() <= 1);
		assertTrue(vector.getY() <= 1);
		assertTrue(almostEqual(vector.length(), 1));
		assertTrue(almostEqual(vector.getX(), 0.4472135954999579));
		assertTrue(almostEqual(vector.getY(), 0.8944271909999159));
	}
}
