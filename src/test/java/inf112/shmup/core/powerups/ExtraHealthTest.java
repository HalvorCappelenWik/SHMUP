package inf112.shmup.core.powerups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.Player;
import inf112.shmup.core.ships.Ship;
import inf112.shmup.core.ships.Tank3;

public class ExtraHealthTest extends GameTestBase {
    @Test
    public void should_health_2_health() {
        Ship player = new Tank3();

        new Player(0, 0).setShip(player);

        player.takeDamage(3);

        new ExtraHealth(0, 0).activate();

        assertEquals(9 - 3 + 2, player.getHealth());
    }
    
    @Test
    public void should_not_exceed_max_health() {
        Ship player = new Tank3();

        new Player(0, 0).setShip(player);

        new ExtraHealth(0, 0).activate();

        assertEquals(9, player.getHealth());
    }
}
