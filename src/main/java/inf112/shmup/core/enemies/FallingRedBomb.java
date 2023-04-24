package inf112.shmup.core.enemies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import inf112.shmup.core.powerups.PowerUp;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.Explosion;

public class FallingRedBomb extends PowerUp {
	
	private final Color DAMAGE_COLOR = Color.BLUE;
	private final int DAMAGE_FRAMES = 3;
	private int _damageFrames = 0;
	
	private static Sprite _sprite = AssetManager.sprite("Bomb_1.png");
	private int health = 5;

	public FallingRedBomb(float x, float y) {
		super(x, y, _sprite);
		_sprite.setColor(Color.RED);
	}

	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(0, -100f * delta);
		
		if(collidesWithPlayer()) takeDamage(health);
	}

	private void onDead() {
		Explosion explosion = new Explosion(getX(), getY(), 100f, 100, true);
		getStage().addActor(explosion);
		remove();
	}

	@Override
	public void takeDamage(int damage) {
		this.health -= damage;
		if (health <= 0) {
			onDead();
		}
		_damageFrames = DAMAGE_FRAMES;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		if (_damageFrames > 0) {
			_damageFrames--;
			sprite.setColor(DAMAGE_COLOR);
		}
		super.draw(batch, parentAlpha);
		sprite.setColor(Color.RED);
	}

	@Override
	protected void activate() {

	}


}
