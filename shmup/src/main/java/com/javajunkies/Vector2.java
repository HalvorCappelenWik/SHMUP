package com.javajunkies;

public class Vector2 {
	private double x;
	private double y;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public static Vector2 zero() { return new Vector2(0, 0); }
	public static Vector2 up() { return new Vector2(0, -1); }
	public static Vector2 down() { return new Vector2(0, 1); }
	public static Vector2 left() { return new Vector2(-1, 0); }
	public static Vector2 right() { return new Vector2(1, 0); }

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[" + this.x + "," + this.y + "]";
	}
	
	public double length() {
		return (float) Math.sqrt(this.sqrLength());
	}
	
	public void add(Vector2 vector) {
		this.x += vector.getX();
		this.y += vector.getY();
	}
	
	public void subtract(Vector2 vector) {
		this.x -= vector.getX();
		this.y -= vector.getY();
	}
	
	public void multiply(double scalar) {
		this.x *= scalar;
		this.y *= scalar;
	}
	
	public static double multiply(Vector2 a, Vector2 b) {
		return (a.getX() * b.getX()) + (a.getY() * b.getY());
	}
	
	public void normalize() {
		double length = this.length();
		if (length == 0.0f) return;
		this.x /= length;
		this.y /= length;
	}
	
	public Vector2 clone() {
		return new Vector2(this.x, this.y);
	}
	
	public double angle() {
		return Math.atan(this.y / this.x);
	}
	
	public boolean isNormal(Vector2 vector) {
		return Vector2.multiply(this,vector) == 0;
	}
	
	public boolean isParalell(Vector2 vector) {
		return (this.x/vector.getX())*vector.getY() == this.y;
	}
	
	public void rotate(double angle) {
		double newX = Math.cos(angle)*this.x-Math.sin(angle)*this.y;
		double newY = Math.sin(angle)*this.x+Math.cos(angle)*this.y;
        this.x = newX;
        this.y = newY;
	}
	
	public Vector2 normal() {
		double oldX = this.x;
		double oldY = this.y;
        this.rotate(0.5 * Math.PI);
        Vector2 newVector = new Vector2(this.x,this.y);
        this.x = oldX;
        this.y = oldY;
        return newVector;
	}
	
	public double sqrLength() {
		return this.x * this.x + this.y * this.y;
	}
}
