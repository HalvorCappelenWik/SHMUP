package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.powerups.Bomb;
import inf112.shmup.core.powerups.FallingRedBomb;
import inf112.shmup.core.powerups.PowerUp;
import inf112.shmup.core.utilities.Damageable;

public class PlayerBullet extends Bullet {

	private static final int _bullet_speed = 2000;

	private final int _damage;

	/**
	 * Constructor for the PlayerBullet class.
	 * @param damage The damage the player bullet should deal
	 */
    public PlayerBullet(int damage) {
		super(_bullet_speed, "bullet_a.png");
		_damage = damage;
    }

	@Override
	void onHitEnemy(Damageable enemy) {
		if(enemy instanceof PowerUp && !(enemy instanceof FallingRedBomb) && !(enemy instanceof Bomb)) {
			return;
		}
		remove();
		enemy.takeDamage(_damage);
	}

	@Override
	void onHitPlayer(Player player) {
		// Nothing
	}

}