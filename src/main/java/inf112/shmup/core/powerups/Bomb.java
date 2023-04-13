package inf112.shmup.core.powerups;
import inf112.shmup.core.utilities.AssetManager;

public class Bomb extends PowerUp {
	
	private final float blastRadius = 100f;
	private final int blastDamage = 3;
	
	public Bomb(float x, float y) {
		setSprite(AssetManager.sprite("Bomb_1.png"));
		setPosition(x, y);
		sprite.setPosition(x, y);
	}

	@Override
	public void takeDamage(int damage) {
		Explosion explosion = new Explosion(getX(), getY(), blastRadius, blastDamage);
		getStage().addActor(explosion);
		remove();
	}
}