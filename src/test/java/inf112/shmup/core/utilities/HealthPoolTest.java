package inf112.shmup.core.utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;

import static org.junit.jupiter.api.Assertions.*;

public class HealthPoolTest extends GameTestBase {
    private HealthPool healthPool;

    /**
     * Sets the healthPool to 100 before each test
     */
    @BeforeEach
    public void setUp() {
        // Initialize a new HealthPool object with max value of 100
        healthPool = new HealthPool(100);
    }

    /**
     * Tests getMax()
     */
    @Test
    public void testGetMax() {
        // Assert that the getMax() method returns the correct max value
        assertEquals(100, healthPool.getMax());
    }

    /**
     * Tests the getCurrent() method
     */
    @Test
    public void testGetCurrent() {
        // Assert that the getCurrent() method returns the correct current value
        assertEquals(100, healthPool.getCurrent());
    }

    /**
     * Tests that healthPool.isDead() returns true when health is 0
     */
    @Test
    public void testIsDead() {
        // Assert that isDead() returns false initially
        assertFalse(healthPool.isDead());

        // Take damage to reduce current value to 0
        healthPool.takeDamage(100);

        // Assert that isDead() returns true after taking damage and current value is 0
        assertTrue(healthPool.isDead());
    }

    /**
     * Tests that healthpool changes correct amount when takeDamaged is called
     */
    @Test
    public void testTakeDamage() {
        // Take damage of 50
        healthPool.takeDamage(50);

        // Assert that the current value is updated correctly
        assertEquals(50, healthPool.getCurrent());

        // Take damage of 200 (exceeding max value)
        healthPool.takeDamage(200);

        // Assert that the current value is updated to 0
        assertEquals(0, healthPool.getCurrent());
    }

    /**
     * Tests that takeDamage with a negative amount heals the healthPool
     */
    @Test
    public void testHeal() {
        // Take damage of 50
        healthPool.takeDamage(50);

        // Assert that the current value is updated correctly
        assertEquals(50, healthPool.getCurrent());

        // "Heal" for 30 by taking negative damage
        healthPool.takeDamage(-30);

        // Assert that the current value is updated correctly
        assertEquals(80, healthPool.getCurrent());

        // Try to "heal" for more than the max value
        healthPool.takeDamage(-30);

        // Assert that the current value is updated to the max value
        assertEquals(100, healthPool.getCurrent());
    }

}