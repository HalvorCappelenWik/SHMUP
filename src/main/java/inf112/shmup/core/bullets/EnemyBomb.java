package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.Damageable;

public class EnemyBomb extends Rocket {

    private static final int _damage = 3;

    /**
     * Constructor for the EnemyBomb class.
     * @param speed The movement speed of the bomb
     */
    public EnemyBomb(float speed) {
        super(speed, "missile_a.png");
        _radius = 60;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if (Player.getInstance().getShip().getY() > this.getY()) {
            this.onHitPlayer(Player.getInstance());
        }
    }

    @Override
    void onHitPlayer(Player player) {
        spawnExplosion(getX(), getY(), _damage);
        remove();
    }

    @Override
    void onHitEnemy(Damageable enemy) {
        // Nothing
    }

}