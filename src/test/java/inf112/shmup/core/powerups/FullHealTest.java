package inf112.shmup.core.powerups;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.Player;
import inf112.shmup.core.ships.Ship;
import inf112.shmup.core.ships.Tank3;

public class FullHealTest extends GameTestBase {
    @Test
    public void should_full_heal_when_damaged() {
        Ship player = new Tank3();

        new Player(0, 0).setShip(player);

        player.takeDamage(8);

        new FullHeal(0, 0).activate();

        assertEquals(9, player.getHealth());
    }
    
    @Test
    public void should_not_heal_when_not_damaged() {
        Ship player = new Tank3();

        new Player(0, 0).setShip(player);

        new FullHeal(0, 0).activate();

        assertEquals(9, player.getHealth());
    }
}
