package inf112.shmup.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.ships.Gunship1;
import inf112.shmup.core.ships.Ship;

public class PlayerTest extends GameTestBase {
	
	/**
	 * Tests that the player instance can be retirived as static field
	 */
    @Test
    public void should_set_static_singleton_reference() {
        Player playerA = new Player(0, 0);
        assertEquals(playerA, Player.getInstance());
        
        Player playerB = new Player(0, 0);
        assertEquals(playerB, Player.getInstance());
    }
    
    /**
     * Tests that when a player is made its ship is not null
     */
    @Test
    public void should_start_with_ship_not_null() {
        Player player = new Player(0, 0);
        assertNotNull(player.getShip());
    }
    
    /**
     * Tests that the setShip(Ship ship) works
     */
    @Test
    public void should_set_ship_successfully() {
        Player player = new Player(0, 0);
        Ship ship = new Gunship1();
        
        assertNotEquals(ship, player.getShip());

        player.setShip(ship);
        assertEquals(ship, player.getShip());
    }
}
