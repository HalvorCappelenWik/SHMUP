package inf112.shmup.core.bullets;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.Player;
import inf112.shmup.core.enemies.EnemyShip;
import inf112.shmup.core.enemies.Grunt2;

public class BulletTest extends GameTestBase {
    @Test
    public void player_bullets_should_damage_enemies() {
        EnemyShip enemy = new Grunt2(0, 0);
        EnemyShip.disableInvincibility(enemy);
        PlayerBullet bullet = new PlayerBullet(1);

        bullet.onHitEnemy(enemy);

        assertEquals(enemy.getMaxHealth() - 1, enemy.getHealth());
    }
    
    @Test
    public void player_bullets_should_not_damage_player() {
        Player player = new Player(0, 0);
        PlayerBullet bullet = new PlayerBullet(1);

        bullet.onHitPlayer(player);

        assertEquals(player.getShip().getMaxHealth(), player.getShip().getHealth());
    }
    @Test
    public void enemy_bullets_should_not_damage_enemies() {
        EnemyShip enemy = new Grunt2(0, 0);
        EnemyShip.disableInvincibility(enemy);
        EnemyBullet bullet = new EnemyBullet(1);

        bullet.onHitEnemy(enemy);

        assertEquals(enemy.getMaxHealth(), enemy.getHealth());
    }
    
    @Test
    public void enemy_bullets_should_damage_player() {
        Player player = new Player(0, 0);
        EnemyBullet bullet = new EnemyBullet(1);

        bullet.onHitPlayer(player);

        assertEquals(player.getShip().getMaxHealth() - 1, player.getShip().getHealth());
    }
}
