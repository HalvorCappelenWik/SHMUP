package com.javajunkies;

/**
 * A 2D vector.
 */
public class Vector2 {
	private double _x;
	private double _y;
	
	/**
	 * Creates a new 2D vector.
	 */
	public Vector2(double x, double y) {
		_x = x;
		_y = y;
	}

	public static Vector2 zero() { return new Vector2(0, 0); }
	public static Vector2 up() { return new Vector2(0, -1); }
	public static Vector2 down() { return new Vector2(0, 1); }
	public static Vector2 left() { return new Vector2(-1, 0); }
	public static Vector2 right() { return new Vector2(1, 0); }

	/**
	 * Gets the X component of the vector.
	 */
	public double getX() {
		return _x;
	}

	/**
	 * Sets the X component of the vector.
	 */
	public void setX(double x) {
		_x = x;
	}

	/**
	 * Gets the Y component of the vector.
	 */
	public double getY() {
		return _y;
	}

	/**
	 * Sets the Y component of the vector.
	 */
	public void setY(double y) {
		_y = y;
	}
	
	/**
	 * Gets the pythagorean length of the vector.
	 */
	public double length() {
		return Math.sqrt(this.sqrLength());
	}
	
	/**
	 * Adds the given vector to this vector component-wise.
	 */
	public void add(Vector2 vector) {
		_x += vector.getX();
		_y += vector.getY();
	}
	
	/**
	 * Subtracts the given vector from this vector component-wise.
	 * @param vector
	 */
	public void subtract(Vector2 vector) {
		_x -= vector.getX();
		_y -= vector.getY();
	}
	
	/**
	 * Multiplies each component of this vector with the given scalar.
	 */
	public void multiply(double scalar) {
		_x *= scalar;
		_y *= scalar;
	}
	
	/**
	 * Computes the dot-product of two vectors.
	 */
	public static double dot(Vector2 a, Vector2 b) {
		return (a.getX() * b.getX()) + (a.getY() * b.getY());
	}
	
	/**
	 * Stretches the length of this vector to 1.0.
	 */
	public void normalize() {
		double length = length();
		if (length == 0.0f) return;
		_x /= length;
		_y /= length;
	}
	
	/**
	 * Creates a new vector equal to this.
	 */
	public Vector2 clone() {
		return new Vector2(_x, _y);
	}
	
	/**
	 * Computes the angle of this vector.
	 */
	public double angle() {
		return Math.atan(_y / _x);
	}
	
	public boolean isNormal(Vector2 vector) {
		return Vector2.dot(this,vector) == 0;
	}
	
	public boolean isParalell(Vector2 vector) {
		return (_x/vector.getX())*vector.getY() == _y;
	}
	
	public void rotate(double angle) {
		double newX = Math.cos(angle)*_x-Math.sin(angle)*_y;
		double newY = Math.sin(angle)*_x+Math.cos(angle)*_y;
        _x = newX;
        _y = newY;
	}
	
	public Vector2 normal() {
		Vector2 normal = clone();
		normal.rotate(0.5 * Math.PI);
        return normal;
	}
	
	public double sqrLength() {
		return _x * _x + _y * _y;
	}
	
	@Override
	public String toString() {
		return "[" + _x + "," + _y + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Vector2)) return false;
		Vector2 vector = (Vector2)obj;
		return Double.compare(_x, vector._x) == 0 && 
			   Double.compare(_y, vector._y) == 0;
	}
}
