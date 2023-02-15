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

	/**
	 * Creates a new GameObject of the type Enemy
	 * @param position Position vector of the enemy
	 * @param size Size vector of the enemy, x is width and y is height
	 */
	public Enemy(Vector2 position, Vector2 size) {
		super(position, size, "enemy");
		_startX = (int) position.getX();
		_endX = (int) position.getX() + 100;
	}

	@Override
	public void update(double deltaTime) {
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