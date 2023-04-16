package inf112.shmup.core.utilities;

import java.util.ArrayList;
import java.util.List;

public class EnemyCollection<TEnemy> {

    private final List<TEnemy> enemies = new ArrayList<>();

    /**
     * @return Gets all spawned enemies.
     */
    public List<TEnemy> getEnemies(){
        return enemies;
    }

    /**
     * Adds an enemy to the kist of spawned enemies.
     * @param enemy Enemy to spawn
     */
    public void spawn(TEnemy enemy){
        enemies.add(enemy);
    }


    /**
     * Removes an enemy if it is found in the enemy list, and removes it from the list
     * @param enemy The instance you want to remove
     * @exception IllegalArgumentExeption if the enemy was not in the enemy factories enemy list
     */
    public void kill(TEnemy enemy){
        if (!enemies.contains(enemy))
            throw new IllegalArgumentException(String.format("Please remove an enemy that is within the enemy list. Attempted to remove %s", enemy.getClass().getSimpleName()));

        enemies.remove(enemy);
    }
}
