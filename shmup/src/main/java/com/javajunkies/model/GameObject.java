package com.javajunkies.model;

import com.javajunkies.Vector2;

public abstract class GameObject {
    
	private Vector2 _position;
	private Vector2 _size;
    private String _sprite;

    public GameObject(Vector2 position, Vector2 size, String sprite) {
        this._position = position.clone();
		this._size = size.clone();
        this._sprite = sprite;
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

	public String getSprite() {
		return _sprite;
	}
	
	public void setSprite(String sprite) {
		_sprite = sprite;
	}
}