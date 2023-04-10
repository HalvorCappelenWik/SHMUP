package inf112.shmup.view.actors;
import inf112.shmup.util.Assets;

public class Bomb extends PowerUp{
	
	private final float blastRadius = 100f;
	private final int blastDamage = 3;
	
	public Bomb(float x, float y) {
		setSprite(Assets.sprite("Bomb_1.png"));
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