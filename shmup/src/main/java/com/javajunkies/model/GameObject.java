package com.javajunkies.model;

import com.javajunkies.Vector2;

/**
 * Base class for on-screen objects with behavior.
 */
public abstract class GameObject {
    
	private Vector2 _position;
	private Vector2 _hitBox;
    private String _sprite;

	/**
	 * Creates a new un-spawned GameObject.
	 * 
	 * @param position Initial position of object.
	 * @param hitBox Initial hit-box of object.
	 * @param sprite Initial sprite of object.
	 */
    public GameObject(Vector2 position, Vector2 hitBox, String sprite) {
        this._position = position.clone();
		this._hitBox = hitBox.clone();
        this._sprite = sprite;
    }

	/**
	 * Notifies the object that it should prepare for the next frame.
	 * 
	 * @param deltaTime Time in seconds elapsed since the previous frame.
	 */
	public abstract void update(float deltaTime);

	/**
	 * Gets the current position of this object.
	 */
	public Vector2 getPosition() {
		return _position;
	}

	/**
	 * Sets the current position of this object.
	 */
	public void setPosition(Vector2 position) {
		_position = position.clone();
	}

	/**
	 * Gets the width and height of this objects hit-box. x is width, y is height.
	 */
	public Vector2 getHitBox() {
		return _hitBox;
	}

	/**
	 * Sets the width and height of this objects hit-box. x is width, y is height.
	 */
	public void setHitBox(Vector2 size) {
		_hitBox = size.clone();
	}

	/**
	 * Moves this object x units horizontally and y units vertically.
	 */
	public void move(Vector2 delta) {
		_position.add(delta);
	}

	/**
	 * Gets the name of the sprite used by this object.
	 */
	public String getSprite() {
		return _sprite;
	}
	
	/**
	 * Sets the name of the sprite used by this object.
	 */
	public void setSprite(String sprite) {
		_sprite = sprite;
	}
}