package inf112.shmup.core.utilities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.enemies.EnemyShip;
import inf112.shmup.core.enemies.Grunt2;

public class ExplosionTest extends GameTestBase {
	
	/**
	 * Tests that an explosion damages enemies
	 */
    @Test
    public void should_damage_enemy() {
        EnemyShip enemy = new Grunt2(0, 0);
        EnemyShip.disableInvincibility(enemy);
        Explosion explosion = new Explosion(0, 0, 0, 1, true);

        explosion.tryDamage(enemy);

        assertEquals(enemy.getMaxHealth() - 1, enemy.getHealth());
    }
    
    /**
     * Tests that enemies do not get damaged by the same explosion more than once
     */
    @Test
    public void should_damage_enemy_only_once() {
        EnemyShip enemy = new Grunt2(0, 0);
        EnemyShip.disableInvincibility(enemy);
        Explosion explosion = new Explosion(0, 0, 0, 1, true);

        explosion.tryDamage(enemy);
        explosion.tryDamage(enemy);

        assertEquals(enemy.getMaxHealth() - 1, enemy.getHealth());
    }
}
