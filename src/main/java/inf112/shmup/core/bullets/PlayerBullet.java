package inf112.shmup.core.bullets;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.Damageable;

public class PlayerBullet extends Bullet {

	private final int _damage;

    public PlayerBullet(int damage) {
		super(2000, "bullet_a.png");
		_damage = damage;
    }

	@Override
	void onHitEnemy(Damageable enemy) {
		remove();
		enemy.takeDamage(_damage);
	}

	@Override
	void onHitPlayer(Player player) {
		//nothing
	}
}
