package inf112.shmup.core.powerups;

import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;

public class FallingRedBombTest extends GameTestBase {
	
	/**
	 * Tests that a falling red bomb does not activate after one hit (of damage 1), as health is more
	 */
    @Test
    public void should_not_activate_on_first_hit() {
        FallingRedBomb powerup = new FallingRedBomb(0, 0);
        powerup.takeDamage(1);

        assertFalse(powerup.isDead());
    }
}
