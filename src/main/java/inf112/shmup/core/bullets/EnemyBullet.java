package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;

public class EnemyBullet extends Bullet {

    private final int _damage;

    public EnemyBullet(int damage) {
        super(-500, "bullet_c.png", "shoot_2");
        setRotationDownwards();
        _damage = damage;
    }
    
    @Override
    protected void checkIfHit() {
        Player player = Player.getInstance();
        if (player == null) return;
       
        if (sprite.getBoundingRectangle().overlaps(player.getShip().getBoundingRectangle())) {
            player.getShip().takeDamage(_damage);
            remove();
        }
    }
}