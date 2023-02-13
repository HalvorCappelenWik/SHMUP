package com.javajunkies.model;

import java.awt.Color;

public class Player extends GameObject {
	private int speed;

    public Player(int positionX, int positionY, int height, int width, int speed, Color color) {
        super(positionX, positionY, height, width, color);
        this.speed = speed;
    }


	@Override
	public void move(int x, int y) {
		this.setPositionX(this.getPositionX() + (x * speed));
		this.setPositionY(this.getPositionY() + (y * speed));
		
	}
}
