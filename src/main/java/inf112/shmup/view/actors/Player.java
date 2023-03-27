package inf112.shmup.view.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.app.ShmupGame;

public class Player extends DrawableActor {

	private final float _secondsBetweenBullets = 0.1f;
	private float _secondsSinceLastBullet = 0f;
	private float speed_x = 5f;
	private float speed_y = 5f;
	
	public boolean killed;

	public Player(float x, float y) {
		
		setPosition(x, y);
		
		setBounds(x, y, getTotalWidth(), getTotalHeight());
		killed = false;

		setSprite("src/assets/ships/ship_blue2.png");
		sprite.setPosition(x, y);
	}

	// -------- actor functions ----------

	@Override
	protected void positionChanged() {
		sprite.setPosition(getX(), getY());
		super.positionChanged();
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
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
			PlayerBullet newBullet = new PlayerBullet(this.getX()+10, this.getY() + getTotalHeight()/2);
			this.getStage().addActor(newBullet);
			_secondsSinceLastBullet = 0f;
		}
		else {
			_secondsSinceLastBullet += delta;
		}

	}


	/**
	 * Method that keeps the object within the scene 
	 * @param x current X coordinate
	 * @param y current Y coordinate
	 */
	private void moveIntoBounds(float x, float y) {
		Rectangle gameBounds = new Rectangle(0,0, ShmupGame.V_WIDTH, ShmupGame.V_WIDTH); //Gdx.graphics.getWidth(), Gdx.graphics.getHeight()
		
		setX(Math.max(gameBounds.x + getTotalWidth()/2, getX()));
		setX(Math.min(gameBounds.x + gameBounds.width - getTotalWidth()/2, getX()));
		setY(Math.max(gameBounds.y + getTotalHeight()/2, getY()));
		setY(Math.min(gameBounds.y + gameBounds.height - getTotalHeight()/2, getY()));
	}
	
	/**
	 * Set the boolean value "killed" to true
	 */
	public void kill() {
		killed = true;
		remove();
	}
}
