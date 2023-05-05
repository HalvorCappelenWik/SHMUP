package inf112.shmup.core.powerups;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.Explosion;

public class Bomb extends PowerUp {
	
	private final float blastRadius = 100f;
	private final int blastDamage = 3;

	/**
	 * Constructor for the Bomb class.
	 * @param x The x-coordinate the bomb should spawn on
	 * @param y The y-coordinate the bomb should spawn on
	 */
	Bomb(float x, float y) {
		super(x, y, AssetManager.sprite("items/bomb_1.png"));
	}

	@Override
	public void activate() {
		Explosion explosion = new Explosion(getX(), getY(), blastRadius, blastDamage, true);
		getStage().addActor(explosion);
		remove();
	}

	@Override
	public void takeDamage(int damage) {
		activate();
	}

}