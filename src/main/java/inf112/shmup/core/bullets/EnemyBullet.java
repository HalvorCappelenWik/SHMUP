package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.Damageable;

public class EnemyBullet extends Bullet {

    private final int _damage;

    public EnemyBullet(int damage) {
        super(500, "bullet_e.png");
        setCollisionScale(0.5f, 0.7f);
        _damage = damage;
    }
    
    @Override
    protected void onHitPlayer(Player player) {
        player.getShip().takeDamage(_damage);
        remove();
    }

    @Override
    void onHitEnemy(Damageable enemy) {
        //nothing
    }
}