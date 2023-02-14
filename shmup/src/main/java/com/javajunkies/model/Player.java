package com.javajunkies.model;

import com.javajunkies.Vector2;

/**
 * The GameObject controlled by the player.
 */
public class Player extends GameObject {
	private final double _speed = 100;
	private final double _secondsBetweenBullets = 0.2d;
	private double _secondsSinceLastBullet = 0;
	private Vector2 _input = Vector2.zero();

    public Player(Vector2 position) {
        super(position, new Vector2(10, 10), "player");
    }

	@Override
	public void update(double deltaTime) {

		// Move
		Vector2 delta = _input.clone();
		delta.normalize();
		delta.multiply(deltaTime * _speed);
		move(delta);

		// Shoot
		if (_secondsSinceLastBullet >= _secondsBetweenBullets) {
			getScene().spawn(new Bullet(getPosition()));
			_secondsSinceLastBullet = 0;
		} else {
			_secondsSinceLastBullet += deltaTime;
		}
	}

	public void setInput(Vector2 input) {
		_input = input;
	}
}