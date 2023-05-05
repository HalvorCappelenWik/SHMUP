package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.Damageable;

public class EnemyBullet extends Bullet {

    private static final int _bullet_speed = 500;

    private final int _damage;

    /**
     * Constructor for the EnemyBullet class.
     * @param damage The amount of damage the bullet deals
     */
    public EnemyBullet(int damage) {
        super(_bullet_speed, "bullet_e.png");
        setCollisionScale(0.5f, 0.7f);
        _damage = damage;
    }
    
    @Override
    public void onHitPlayer(Player player) {
        player.getShip().takeDamage(_damage);
        remove();
    }

    @Override
    public void onHitEnemy(Damageable enemy) {
        // Nothing
    }

}