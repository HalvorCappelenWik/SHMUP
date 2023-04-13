package inf112.shmup.view.actors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import inf112.shmup.core.utilities.EnemyCollection;
import org.junit.jupiter.api.Test;

public class EnemyCollectionTest {
    private final static String TEST_ENEMY = "Enemy";

    @Test
    public void canSpawnEnemy() {
        EnemyCollection<String> factory = new EnemyCollection<>();

        factory.spawn(TEST_ENEMY);

        assertTrue(factory.getEnemies().contains(TEST_ENEMY));
    }

    @Test
    public void canKillEnemy() {
        EnemyCollection<String> factory = new EnemyCollection<>();

        factory.spawn(TEST_ENEMY);

        factory.kill(TEST_ENEMY);

        assertFalse(factory.getEnemies().contains(TEST_ENEMY));
    }

    @Test
    public void cannotKillUnspawnedEnemy() {
        EnemyCollection<String> factory = new EnemyCollection<>();

        try
        {
            factory.kill(TEST_ENEMY);
        }
        catch (IllegalArgumentException e) {
            return;
        }
        fail("Should not be allowed to kill unspawned enemy.");
    }
}