package com.javajunkies.model;


public abstract class GameObject {
    
    private int positionX;
    private int positionY;
    private int width;
    private int heigtht;

    public GameObject(int positionX, int positionY, int height, int width) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.heigtht = height;
        this.width = width;
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

}
