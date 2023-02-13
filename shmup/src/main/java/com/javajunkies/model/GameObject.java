package com.javajunkies.model;

import java.awt.Color;

import com.javajunkies.Vector2;

public abstract class GameObject {
    
	private Vector2 _position;
	private Vector2 _size;
    private Color _color;

    public GameObject(Vector2 position, Vector2 size, Color color) {
        this._position = position.clone();
		this._size = size.clone();
        this._color = color;
    }

	public abstract void update(float deltaTime);

	public Vector2 getPosition() {
		return _position;
	}

	public void setPosition(Vector2 position) {
		_position = position.clone();
	}

	public Vector2 getSize() {
		return _size;
	}

	public void setSize(Vector2 size) {
		_size = size.clone();
	}

	public void move(Vector2 delta) {
		_position.add(delta);
	}

	public Color getColor() {
		return _color;
	}
	
	public void setColor(Color color) {
		_color = color;
	}
}