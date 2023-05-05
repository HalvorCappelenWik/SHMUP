package inf112.shmup.core.ships;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;

public class ShipTest extends GameTestBase {
    @Test
    public void should_start_with_max_health() {
        Ship ship = new Gunship1();
        assertEquals(ship.getMaxHealth(), ship.getHealth());
    }

    @Test
    public void should_take_damage() {
        Ship ship = new Gunship1();
        ship.takeDamage(2);

        assertEquals(ship.getMaxHealth() - 2, ship.getHealth());
    }

    @Test
    public void should_die_when_health_is_empty() {
        Ship ship = new Gunship1();
        ship.takeDamage(ship.getMaxHealth());

        assertEquals(true, ship.isDead());
    }

    @Test
    public void should_start_with_some_speed() {
        Ship ship = new Gunship1();
        assertTrue(ship.getSpeedX() > 0);
        assertTrue(ship.getSpeedY() > 0);
    }
}
