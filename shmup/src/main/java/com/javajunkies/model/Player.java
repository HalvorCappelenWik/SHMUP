package com.javajunkies.model;


public class Player extends GameObject {


    public Player(int positionX, int positionY, int height, int width) {
        super(positionX, positionY, height, width);
    }


	@Override
	public void move(int x, int y) {
		this.setPositionX(this.getPositionX() + x);
		this.setPositionY(this.getPositionY() + y);
		
	}
}
