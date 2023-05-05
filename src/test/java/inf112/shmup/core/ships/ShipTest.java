package inf112.shmup.core.ships;

import inf112.shmup.core.GameTestBase;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShipTest extends GameTestBase {
	
	/**
	 * Tests that a new ship starts with max health
	 */
    @Test
    public void should_start_with_max_health() {
        Ship ship = new Gunship1();
        assertEquals(ship.getMaxHealth(), ship.getHealth());
    }

    /**
     * Tests that a ship takes damage given in takeDamage
     */
    @Test
    public void should_take_damage() {
        Ship ship = new Gunship1();
        ship.takeDamage(2);

        assertEquals(ship.getMaxHealth() - 2, ship.getHealth());
    }

    /**
     * Tests that ship.isDead() returns true when health is 0
     */
    @Test
    public void should_die_when_health_is_empty() {
        Ship ship = new Gunship1();
        ship.takeDamage(ship.getMaxHealth());

        assertEquals(true, ship.isDead());
    }

    /**
     * Tests that when a ship is spawned its speed is greater than 0 in both x and y
     */
    @Test
    public void should_start_with_some_speed() {
        Ship ship = new Gunship1();
        assertTrue(ship.getSpeedX() > 0);
        assertTrue(ship.getSpeedY() > 0);
    }

    /**
     * Tests that racer level 1 has greater speed than all others level 1
     */
    @Test
    public void racer_1_is_fastest_1_ship() {
        Ship racer = new Racer1();

        List<Ship> others = List.of(new Gunship1(), new Tank1(), new Rocketeer1());

        for (Ship other : others)
        {
            assertTrue(racer.getSpeedX() > other.getSpeedX());
            assertTrue(racer.getSpeedY() > other.getSpeedY());
        }
    }

    /**
     * Tests that racer level 2 is faster than all others level 2
     */
    @Test
    public void racer_2_is_fastest_2_ship() {
        Ship racer = new Racer2();

        List<Ship> others = List.of(new Gunship2(), new Tank2(), new Rocketeer2());

        for (Ship other : others)
        {
            assertTrue(racer.getSpeedX() > other.getSpeedX());
            assertTrue(racer.getSpeedY() > other.getSpeedY());
        }
    }

    /**
     * Tests that racer level 3 is faster than all others level 3
     */
    @Test
    public void racer_3_is_fastest_3_ship() {
        Ship racer = new Racer3();

        List<Ship> others = List.of(new Gunship3(), new Tank3(), new Rocketeer3());

        for (Ship other : others)
        {
            assertTrue(racer.getSpeedX() > other.getSpeedX());
            assertTrue(racer.getSpeedY() > other.getSpeedY());
        }
    }

    /**
     * Tests that a tank level 1 has the most amount of health amount level 1 ships
     */
    @Test
    public void tank_1_is_healthiest_1_ship() {
        Ship tank = new Tank1();

        List<Ship> others = List.of(new Gunship1(), new Racer1(), new Rocketeer1());

        for (Ship other : others)
            assertTrue(tank.getMaxHealth() > other.getMaxHealth());
    }

    /**
     * Tests that a tank level 2 has the most amount of health amount level 2 ships
     */
    @Test
    public void tank_2_is_healthiest_2_ship() {
        Ship tank = new Tank2();

        List<Ship> others = List.of(new Gunship2(), new Racer2(), new Rocketeer2());

        for (Ship other : others)
            assertTrue(tank.getMaxHealth() > other.getMaxHealth());
    }

    /**
     * Tests that a tank level 3 has the most amount of health amount level 3 ships
     */
    @Test
    public void tank_3_is_healthiest_3_ship() {
        Ship tank = new Tank3();

        List<Ship> others = List.of(new Gunship3(), new Racer3(), new Rocketeer3());

        for (Ship other : others)
            assertTrue(tank.getMaxHealth() > other.getMaxHealth());
    }

}