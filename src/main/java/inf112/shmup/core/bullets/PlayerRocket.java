package inf112.shmup.core.bullets;

import inf112.shmup.core.Player;
import inf112.shmup.core.powerups.Bomb;
import inf112.shmup.core.powerups.FallingRedBomb;
import inf112.shmup.core.powerups.PowerUp;
import inf112.shmup.core.utilities.Damageable;

public class PlayerRocket extends Rocket {

    private static final int _rocket_speed = 400;

    private int _damage;

    /**
     * Constructor for the PlayerRocket class.
     * @param damage The amount of damage a rocket deals
     */
    public PlayerRocket(int damage){
        super(_rocket_speed, "missile_a.png");
        _damage = damage;
        _radius = 100;
    }

    @Override
    public void onHitEnemy(Damageable enemy) {
    	if(enemy instanceof PowerUp && !(enemy instanceof FallingRedBomb) && !(enemy instanceof Bomb)) {
			return;
		}
        enemy.takeDamage(1);
        spawnExplosion(getX(), getY(), _damage, false);

        remove();
    }

    @Override
    public void onHitPlayer(Player player) {
        // Nothing
    }
    
}