package com.javajunkies.model;

import java.awt.Color;

public abstract class GameObject {
    
    private int positionX;
    private int positionY;
    private int width;
    private int heigtht;
    private Color color;

    public GameObject(int positionX, int positionY, int height, int width, Color color) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.heigtht = height;
        this.width = width;
        this.color = color;
    }


    public abstract void move(int deltaX, int deltaY);


	public int getPositionX() {
		return positionX;
	}


	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}


	public int getPositionY() {
		return positionY;
	}


	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}


	public int getWidth() {
		return width;
	}


	public void setWidth(int width) {
		this.width = width;
	}


	public int getHeigtht() {
		return heigtht;
	}


	public void setHeigtht(int heigtht) {
		this.heigtht = heigtht;
	}
	
	public Color getColor() {
		return this.color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

}
