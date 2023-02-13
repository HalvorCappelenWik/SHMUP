package com.javajunkies;

public class Vector2 {
	private double x;
	private double y;
	
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

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
	
	public boolean equals(Vector2 vector) {
		return this.x == vector.getX() && this.y == vector.getY();
	}
	
	public double length() {
		return Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
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
		Double newX = (double) ((double) this.x) / ((double) this.length());
		Double newY = (double) ((double) this.y) / ((double) this.length());
		this.x = newX;
		this.y = newY;
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
		return Math.sqrt(this.length());
	}
}
