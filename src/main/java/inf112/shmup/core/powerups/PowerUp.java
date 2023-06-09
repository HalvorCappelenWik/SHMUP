package inf112.shmup.core.powerups;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.Damageable;
import inf112.shmup.core.utilities.SpriteActor;

public abstract class PowerUp extends SpriteActor implements Damageable {

	/**
	 * Constructor for the PowerUp class.
	 * @param x The x-coordinate to spawn the powerup at
	 * @param y The y-coordinate to spawn the powerup at
	 * @param sprite The sprite of the powerup
	 */
	protected PowerUp(float x, float y, Sprite sprite) {
		super(sprite);
		setPosition(x, y);
		if (sprite != null)
			sprite.setPosition(x, y);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(0, -200f * delta);
		
		if(collidesWithPlayer()) activate();
	}
	
	@Override
	protected void positionChanged() {
		// TODO Auto-generated method stub
		super.positionChanged();
		if (sprite == null)
			return;
			
		sprite.setX(getX(Align.center) - sprite.getWidth()/2);
		sprite.setY(getY(Align.center) - sprite.getHeight()/2);
	}

	/** Returns true if the powerup collides with the player, false otherwise */
	protected boolean collidesWithPlayer() {
		Player player = Player.getInstance();
		if (player == null) return false;

		return getCollisionBox().overlaps(player.getShip().getCollisionBox());
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}

	@Override
	public Rectangle getBounds() {
		return sprite.getBoundingRectangle();
	}
	
	/**
	 * Activates the powerup ability
	 */
	protected abstract void activate();
}
