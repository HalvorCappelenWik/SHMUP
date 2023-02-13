package com.javajunkies.model;

import com.javajunkies.Vector2;

public class Player extends GameObject {
	private Vector2 _input = new Vector2(0, 0);
	private int _speed;

    public Player(Vector2 position, Vector2 size, int speed) {
        super(position, size, "player");
        this._speed = speed;
    }

	@Override
	public void update(float deltaTime) {
		Vector2 delta = _input.clone();
		delta.normalize();
		delta.multiply(deltaTime * _speed);
		move(delta);
	}

	public void setInput(Vector2 input) {
		_input = input;
	}
}