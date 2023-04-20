package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.Damageable;

public class PlayerRocket extends Rocket{

    private int _damage;

    public PlayerRocket(int damage){
        super(400, "missile_a.png");
        _damage = damage;
        _radius = 100;
    }

    @Override
    void onHitEnemy(Damageable enemy) {
        spawnExplosion(getX(), getY(), _damage);
        remove();
    }

    @Override
    void onHitPlayer(Player player) {
        //nothing
    }
    
}
