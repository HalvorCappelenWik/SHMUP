package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.powerups.Bomb;
import inf112.shmup.core.powerups.FallingRedBomb;
import inf112.shmup.core.powerups.PowerUp;
import inf112.shmup.core.utilities.Damageable;

public class PlayerBullet extends Bullet {

	private final int _damage;

    public PlayerBullet(int damage) {
		super(2000, "bullet_a.png");
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
		//nothing
	}
}
