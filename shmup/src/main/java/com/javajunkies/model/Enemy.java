package com.javajunkies.model;

import com.javajunkies.Vector2;

/**
 * A simple enemy moving from side to side.
 */
public class Enemy extends GameObject{

	private final int _startX;
	private final int _endX;
	private final int _speed = 100;
	private int _direction = 1;

	public Enemy(int positionX, int positionY, int height, int width) {
		super(new Vector2(positionX, positionY), new Vector2(height, width), "enemy");
		_startX = positionX;
		_endX = positionX + 100;
	}

	@Override
	public void update(float deltaTime) {
		Vector2 delta = new Vector2(_direction, 0);
		delta.multiply(deltaTime * _speed);
		move(delta);

		if (getPosition().getX() < _startX) {
			setPosition(new Vector2(_startX, getPosition().getY()));
			_direction = 1;
		}
		if (getPosition().getX() > _endX) {
			setPosition(new Vector2(_endX, getPosition().getY()));
			_direction = -1;
		}
	}
}