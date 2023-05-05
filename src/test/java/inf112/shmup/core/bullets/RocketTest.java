package inf112.shmup.core.bullets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.enemies.EnemyShip;
import inf112.shmup.core.enemies.Grunt2;

public class RocketTest extends GameTestBase {
    @Test
    public void player_rocket_should_damage_enemy()
    {
        EnemyShip enemy = new Grunt2(0, 0);
        EnemyShip.disableInvincibility(enemy);
        PlayerRocket rocket = new PlayerRocket(1);

        rocket.onHitEnemy(enemy);

        assertTrue(enemy.getHealth() < enemy.getMaxHealth());
    }

    @Test
    public void player_rocket_should_damage_enemy_by_1_regardless_of_rocket_damage()
    {
        EnemyShip enemy = new Grunt2(0, 0);
        EnemyShip.disableInvincibility(enemy);
        PlayerRocket rocket = new PlayerRocket(10000000);

        rocket.onHitEnemy(enemy);

        assertEquals(enemy.getMaxHealth() - 1, enemy.getHealth());
    }
}
