package com.javajunkies.model;

import com.javajunkies.Vector2;

/**
 * Base class for on-screen objects with behavior.
 */
public abstract class GameObject {
    
	private Vector2 _position;
	private Vector2 _hitBox;
  private String _sprite;
	private GameScene _scene;

	/**
	 * Creates a new un-spawned {@link GameObject}.
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
	public abstract void update(double deltaTime);

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

	/**
	 * Sets the scene containing this object.
	 * @param scene GameScene. Can be {@code null}.
	 */
	public void setScene(GameScene scene) {
		_scene = scene;
		if (scene != null)
		{
			_scene.spawn(this);
		}
	}

	/**
	 * Gets the scene containing this object.
	 */
	public GameScene getScene() {
		return _scene;
	}

	public boolean collides(GameObject object){
		Vector2 l1 = this.getPosition();
		Vector2 r1 = new Vector2(l1.getX() + this._hitBox.getX(), l1.getY() + this._hitBox.getY());

		Vector2 l2 = object.getPosition();
		Vector2 r2 = new Vector2(l2.getX() + object._hitBox.getX(), l2.getY() + object._hitBox.getY());

		// if rectangle has area 0, no overlap
		if (l1.getX() == r1.getX() || l1.getY() == r1.getY() || r2.getX() == l2.getX() || l2.getY() == r2.getY())
			return false;

		// If one rectangle is on left side of other
		if (l1.getX() > r2.getX() || l2.getX() > r1.getX()) {
			return false;
		}

		// If one rectangle is above other
		if (r1.getY() > l2.getY() || r2.getY() > l1.getY()) {
			return false;
		}

		return true;
	}
}
