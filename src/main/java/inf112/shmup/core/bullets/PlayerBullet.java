package inf112.shmup.core.bullets;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.utilities.Damageable;

public class PlayerBullet extends Bullet {

	private final int _damage;

    public PlayerBullet(int damage) {
		super(2000, "bullet_a.png");
		_damage = damage;
    }

	@Override
	protected void checkIfHit() {
		Rectangle bounds = sprite.getBoundingRectangle();

		if (getStage() == null)
			return;
		
		List<Damageable> actorsHit = new ArrayList<>();

		for (Actor actor : getStage().getActors()) {
			if (actor instanceof Damageable) {
				Damageable damageable = (Damageable) actor;

				if (bounds.overlaps(damageable.getBounds())) {
					actorsHit.add(damageable);
				}
			}
		}
		
		if (actorsHit.isEmpty()) return;
		
		remove();
		for (Damageable d : actorsHit) 
			d.takeDamage(_damage);
	}
}
