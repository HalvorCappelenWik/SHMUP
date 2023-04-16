package inf112.shmup.core.bullets;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.DrawableActor;

public abstract class Bullet extends DrawableActor {

	public Bullet(float x, float y) {
		setSprite(AssetManager.sprite("bullets/bullet_a.png"));
		setPosition(x, y, Align.center);
	}

// -------------- Override actor methods ------------------------
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		positionChanged();
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		move(delta);
		Rectangle bounds = new Rectangle(0, 0, Game.V_WIDTH, Game.V_HEIGHT);
		if (!bounds.overlaps(sprite.getBoundingRectangle())) {
			this.remove();
		}
	}
	
// --------------------- Utility ------------------------

	/**	
	 * Method for moving in the act method. Disctinct method to avoid an issue where you could not change the speed in child objects
	 */
	protected void move(float delta){
		moveBy(0, 1000);
	}	
}