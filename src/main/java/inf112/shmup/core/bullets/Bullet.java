package inf112.shmup.core.bullets;

import com.badlogic.gdx.graphics.g2d.Batch;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;
import inf112.shmup.core.utilities.SpriteActor;

public abstract class Bullet extends SpriteActor {

	private final float _speed;

	public Bullet(float speed, String bulletSprite, String shootSound) {
		super(AssetManager.sprite("bullets/" + bulletSprite));
		AudioPlayer.playEffect(shootSound);
		_speed = speed;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		moveBy(0, _speed * delta);

		if (!isOnScreen()) {
			this.remove();
			return;
		}

		checkIfHit();
	}

	abstract void checkIfHit();
}