package inf112.shmup.view.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {

	private final float _secondsBetweenBullets = 0.2f;
	private float _secondsSinceLastBullet = 0f;

	Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/playerShip1_blue.png")));
	
	public Player() {
		setBounds(1, 1, sprite.getWidth(), sprite.getHeight());
	}

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
			if(moveInBounds(-5f, 0)) 	this.moveBy(-5f, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
			if(moveInBounds(5f, 0))	this.moveBy(5f, 0);
		if(Gdx.input.isKeyPressed(Input.Keys.UP))
			if(moveInBounds(0, 5f))	this.moveBy(0, 5f);
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
			if(moveInBounds(0, -5f))	this.moveBy(0, -5f);

		// Spawn new bullet every 200th of a second
		if(_secondsSinceLastBullet > _secondsBetweenBullets) {
			PlayerBullet newBullet = new PlayerBullet(this.getX() + this.getWidth()/2, this.getY() + this.getHeight());
			this.getStage().addActor(newBullet);
			_secondsSinceLastBullet = 0f;
		}
		else {
			_secondsSinceLastBullet += delta;
		}
	}
	
	public Sprite getSprite() {
		return sprite;
	}

	private boolean moveInBounds(float x, float y) {
		Rectangle gameBounds = new Rectangle(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Rectangle playerBounds = this.getSprite().getBoundingRectangle();
		float newPlayerX = playerBounds.getX() + x;
		float newPlayerY = playerBounds.getY() + y;
		playerBounds.setX(newPlayerX);
		playerBounds.setY(newPlayerY);

		return gameBounds.contains(playerBounds);
	}
}
