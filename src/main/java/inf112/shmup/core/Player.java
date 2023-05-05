package inf112.shmup.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.ships.Gunship1;
import inf112.shmup.core.ships.Ship;

public class Player extends Actor {

	private static Player _instance;
	private Ship _ship;

	/**
	 * Constructor for the Player class.
	 * @param x The x-coordinate the player starts at
	 * @param y The y-coordinate the player starts at
	 */
	public Player(float x, float y) {
		_instance = this;
		_ship = new Gunship1();
		_ship.setPosition(x, y, Align.center);
	}

	@Override
	public void act(float delta) {

		// Input handling
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			_ship.moveBy(-_ship.getSpeedX() * delta, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			_ship.moveBy(_ship.getSpeedX() * delta, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			_ship.moveBy(0, _ship.getSpeedY() * delta);
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			_ship.moveBy(0, -_ship.getSpeedY() * delta);

		_ship.clampToScreen();

		if (_ship.isDead()) {
			_ship.remove();
			remove();
		}
	}

	@Override
	protected void setStage(Stage stage) {
		super.setStage(stage);
		if (stage != null)
			stage.addActor(_ship);
	}

	/**
	 * Gets the player ship.
	 * @return the player ship
	 */
	public Ship getShip() {
		return _ship;
	}

	/**
	 * Sets the player ships new x and y coordinates 
	 * @param ship The ship to set the new position to
	 */
	public void setShip(Ship ship) {
		float x = _ship.getX(Align.center),
			  y = _ship.getY(Align.center);
		_ship.remove();
		_ship = ship;
		_ship.setPosition(x, y, Align.center);
		_ship.setRotation(0f);
		if (getStage() != null)
			getStage().addActor(_ship);
		System.out.println("Changed ship: " + _ship.getClass().getName());
	}

	/**
	 * Gets instance of player.
	 * @return the player instance
	 */
	public static Player getInstance() {
		return _instance;
	}

}