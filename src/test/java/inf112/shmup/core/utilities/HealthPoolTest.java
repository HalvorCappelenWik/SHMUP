package inf112.shmup.core.utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HealthPoolTest {
    private HealthPool healthPool;

    @BeforeEach
    public void setUp() {
        // Initialize a new HealthPool object with max value of 100
        healthPool = new HealthPool(100);
    }

    @Test
    public void testGetMax() {
        // Assert that the getMax() method returns the correct max value
        assertEquals(100, healthPool.getMax());
    }

    @Test
    public void testGetCurrent() {
        // Assert that the getCurrent() method returns the correct current value
        assertEquals(100, healthPool.getCurrent());
    }

    @Test
    public void testIsDead() {
        // Assert that isDead() returns false initially
        assertFalse(healthPool.isDead());

        // Take damage to reduce current value to 0
        healthPool.takeDamage(100);

        // Assert that isDead() returns true after taking damage and current value is 0
        assertTrue(healthPool.isDead());
    }

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
}
