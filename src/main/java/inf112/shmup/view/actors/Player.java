package inf112.shmup.view.actors;

import javax.swing.text.Position;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.app.ShmupGame;

public class Player extends Actor {

	private final float _secondsBetweenBullets = 0.2f;
	private float _secondsSinceLastBullet = 0f;
	private float speed_x = 5f;
	private float speed_y = 5f;

	Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/playerShip1_blue.png")));

	public Player() {
		sprite.setOrigin(0,0);
		//sprite.setScale(2, 2);
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
			PlayerBullet newBullet = new PlayerBullet(this.getX() + (this.getWidth() * sprite.getScaleX())/2, this.getY() + (this.getHeight() * sprite.getScaleY()));
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

	/**
	 * Temporary function for getting the coordinates at the ends of the bounding box 
	 * (might be on the chopping block if never used or not not sufficient)
	 * @param sprite Which sprite to check for
	 * @param side which side ("top","bottom","left","right")
	 * @return The respective x / y coordinate of the side you ask for
	 */
	private float bbox(Sprite sprite, String side){
		Rectangle bounds = sprite.getBoundingRectangle();
		switch(side){
			case "top":
				return bounds.y + bounds.height * sprite.getScaleX();
			case "bottom":
				return bounds.y;
			case "left":
				return bounds.x;
			case "right":
				return bounds.y + bounds.width * sprite.getScaleY();
			default:
				throw new IllegalArgumentException("String not a legal direction, choose 'top', 'bottom', 'left', 'right'");
				
		}
	}

	/**
	 * Method that keeps the player within the scene 
	 * @param x current X coordinate
	 * @param y current Y coordinate
	 */
	private void moveIntoBounds(float x, float y) {
		Rectangle gameBounds = new Rectangle(0,0, ShmupGame.V_WIDTH, ShmupGame.V_WIDTH); //Gdx.graphics.getWidth(), Gdx.graphics.getHeight()
		
		setX(Math.max(gameBounds.x, getX()));
		setX(Math.min(gameBounds.x + gameBounds.width - sprite.getWidth() * sprite.getScaleX(), getX()));
		setY(Math.max(gameBounds.y, getY()));
		setY(Math.min(gameBounds.y + gameBounds.height - sprite.getHeight()* sprite.getScaleY(), getY()));
	}
}
