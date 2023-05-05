package inf112.shmup.core.enemies;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.ships.Ship;

public class EnemyShipTests extends GameTestBase {
	
	/**
	 * Tests that starting direction of enemies is down (-180 degrees)
	 */
    @Test
    public void all_enemies_should_start_pointing_downwards() {
        List<EnemyShip> enemies = List.of(new Bomber1(0, 0), new Grunt1(0, 0), new Grunt2(0, 0), new StrafeEnemy(0, 0));

        for (EnemyShip enemy : enemies) {
            assertEquals(-180, enemy.getRotation());
        }
    }

    /**
     * Tests that an enemy of type grunt1 has more health than grun2
     */
    @Test
    public void grunt_1_should_have_more_health_than_grunt2() {
        Ship grunt1 = new Grunt1(0, 0);
        Ship grunt2 = new Grunt2(0, 0);

        assertTrue(grunt2.getMaxHealth() > grunt1.getMaxHealth());
    }

    /**
     * Tests that a zig enemy is at a slight angle
     */
    @Test
    public void zig_should_be_angled() {
        Ship zig = new Zig1(0, 0);

        assertTrue(zig.getRotation() != 0);
        assertTrue(zig.getRotation() != 180);
        assertTrue(zig.getRotation() != -180);
    }
}
