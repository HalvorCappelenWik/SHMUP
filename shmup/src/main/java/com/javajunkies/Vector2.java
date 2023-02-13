package com.javajunkies;

public class Vector2 {
	private float x;
	private float y;
	
	public Vector2(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "[" + this.x + "," + this.y + "]";
	}
	
	public float length() {
		return (float) Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));
	}
	
	public void add(Vector2 vector) {
		this.x += vector.getX();
		this.y += vector.getY();
	}
	
	public void subtract(Vector2 vector) {
		this.x -= vector.getX();
		this.y -= vector.getY();
	}
	
	public void multiply(float scalar) {
		this.x *= scalar;
		this.y *= scalar;
	}
	
	public static float multiply(Vector2 a, Vector2 b) {
		return (a.getX() * b.getX()) + (a.getY() * b.getY());
	}
	
	public void normalize() {
		this.x /= this.length();
		this.y /= this.length();
	}
	
	public Vector2 clone() {
		return new Vector2(this.x, this.y);
	}
	
	public float angle() {
		return (float) Math.atan(this.y / this.x);
	}
	
	public boolean isNormal(Vector2 vector) {
		return Vector2.multiply(this,vector) == 0;
	}
	
	public boolean isParalell(Vector2 vector) {
		return (this.x/vector.getX())*vector.getY() == this.y;
	}
	
	public void rotate(float angle) {
		float newX = (float) (Math.cos(angle)*this.x-Math.sin(angle)*this.y);
        float newY = (float) (Math.sin(angle)*this.x+Math.cos(angle)*this.y);
        this.x = newX;
        this.y = newY;
	}
	
	public Vector2 normal() {
		float oldX = this.x;
        float oldY = this.y;
        this.rotate((float) (0.5 * Math.PI));
        Vector2 newVector = new Vector2(this.x,this.y);
        this.x = oldX;
        this.y = oldY;
        return newVector;
	}
	
	public float sqrLength() {
		return (float) (Math.sqrt(this.length()));
	}
}
