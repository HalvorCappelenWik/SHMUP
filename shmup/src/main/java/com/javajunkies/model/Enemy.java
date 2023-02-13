package com.javajunkies.model;

import java.awt.Color;

import com.javajunkies.Vector2;

public class Enemy extends GameObject{

	public Enemy(int positionX, int positionY, int height, int width) {
		super(new Vector2(positionX, positionY), new Vector2(height, width), "enemy");
	}

	@Override
	public void update(float deltaTime) {
		
	}
}