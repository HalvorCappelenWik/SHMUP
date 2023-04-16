package inf112.shmup.core.bullets;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.enemies.Damageable;
import inf112.shmup.core.utilities.AssetManager;


public class PlayerBullet extends Bullet {

	private final int _damage;

    public PlayerBullet(float x, float y, int damage) {
        super(x, y);
		_damage = damage;
		setSprite(AssetManager.sprite("bullets/bullet_a.png"));
    }

// ------------------------------- Override actor methods -----------------------------------

    @Override
    protected void move(float delta) {
        moveBy(0, 2000*delta);
    }
    
    @Override
	public void act(float delta) {
		super.act(delta);
		damageIfCollide();
	}

// --------------------------- Utility -----------------------------------
    
	private void damageIfCollide() {
		Rectangle bounds = sprite.getBoundingRectangle();

		if (getStage() == null)
			return;

		for (Actor actor : getStage().getActors()) {
			if (actor instanceof Damageable) {
				Damageable damageable = (Damageable) actor;

				if (bounds.overlaps(damageable.getBounds())) {

					// Temporary damage:
					damageable.takeDamage(_damage);
					remove();
				}
			}
		}
	}
}
