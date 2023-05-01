package inf112.shmup.core.powerups;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.Damageable;
import inf112.shmup.core.utilities.SpriteActor;

public abstract class PowerUp extends SpriteActor implements Damageable {

	protected PowerUp(float x, float y, Sprite sprite) {
		super(sprite);
		setPosition(x, y);
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
		sprite.setX(getX(Align.center) - sprite.getWidth()/2);
		sprite.setY(getY(Align.center) - sprite.getHeight()/2);
	}

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
