package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.powerups.Bomb;
import inf112.shmup.core.powerups.FallingRedBomb;
import inf112.shmup.core.powerups.PowerUp;
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
    	if(enemy instanceof PowerUp && !(enemy instanceof FallingRedBomb) && !(enemy instanceof Bomb)) {
			return;
		}
        enemy.takeDamage(-1);
        spawnExplosion(getX(), getY(), _damage);

        remove();
    }

    @Override
    void onHitPlayer(Player player) {
        //nothing
    }
    
}
