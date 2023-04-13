package inf112.shmup.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.ui.DrawableActor;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Player extends DrawableActor {

	private final float _secondsBetweenBullets = 0.65f;
	private float _secondsSinceLastBullet = 0f;
	private float speed_x = 5f;
	private float speed_y = 5f;

	private int health;
	private int maxHealth;
	
	public boolean killed;

	public Player(float x, float y) {
		
		setSprite(AssetManager.sprite("ships/ship_blue2.png"));
		setPosition(x, y, Align.center);
		killed = false;
		health = maxHealth = 3;
	}

// ------------------------------- Override actor methods -----------------------------------

	@Override
	public void draw(Batch batch, float parentAlpha) {
		positionChanged();
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		
		// Input handling
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
			this.moveBy(-speed_x, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			this.moveBy(speed_x, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			this.moveBy(0, speed_y);
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			this.moveBy(0, -speed_y);

		moveIntoBounds(getX(), getY());
		

		// Spawn new bullet every 200th of a second
		if(_secondsSinceLastBullet > _secondsBetweenBullets) {
			PlayerBullet newBullet = new PlayerBullet(this.getX(Align.center), this.getY(Align.top), 1);
			this.getStage().addActor(newBullet);
			AudioPlayer.playEffect("shoot_1");
			_secondsSinceLastBullet = 0f;
		}
		else {
			_secondsSinceLastBullet += delta;
		}

	}

// ----------------------- Utility ------------------------------

	/**
	 * Method that keeps the object within the scene 
	 * @param x current X coordinate
	 * @param y current Y coordinate
	 */
	private void moveIntoBounds(float x, float y) {
		Rectangle gameBounds = new Rectangle(0,0, Game.V_WIDTH, Game.V_WIDTH);
		
		setX(Math.max(gameBounds.x, getX()));
		setX(Math.min(gameBounds.x + gameBounds.width - getWidth(), getX()));
		setY(Math.max(gameBounds.y, getY()));
		setY(Math.min(gameBounds.y + gameBounds.height - getHeight(), getY()));
	}
	
	public void takeDamage(int damage) {
		health -= damage;
		AudioPlayer.playEffect("player_killed");

		if (health > 0)
			return;

		health = 0;
		killed = true;
		remove();
	}
}
