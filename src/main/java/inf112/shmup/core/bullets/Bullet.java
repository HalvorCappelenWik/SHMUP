package inf112.shmup.core.bullets;

import com.badlogic.gdx.graphics.g2d.Batch;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.SpriteActor;

public abstract class Bullet extends SpriteActor {

	private final float _speed;

	public Bullet(float speed, String bulletSprite) {
		super(AssetManager.sprite("bullets/" + bulletSprite));
		_speed = speed;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		float x = (float)Math.sin(Math.toRadians(getRotation())) * _speed * delta;
		float y = (float)Math.cos(Math.toRadians(getRotation())) * _speed * delta;

		moveBy(x, y);

		if (!isOnScreen()) {
			this.remove();
			return;
		}

		checkIfHit();
	}

	abstract void checkIfHit();
}