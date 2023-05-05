package inf112.shmup.core.enemies;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.HashMap;
import java.util.function.BiFunction;

public class EnemyFactory extends Actor {

    private static EnemyFactory _instance;

    /**
     * Constructor for the EnemyFactory class.
     */
    public EnemyFactory() {
        _instance = this;
        registerEnemy("grunt1", (x, y) -> new Grunt1(x, y));
        registerEnemy("grunt2", (x, y) -> new Grunt2(x, y));
        registerEnemy("bomber1", (x, y) -> new Bomber1(x, y));
        registerEnemy("zig1", 	(x, y) -> new Zig1	(x, y));
        registerEnemy("strafe1",(x, y) -> new StrafeEnemy(x, y));
    }

    private static final HashMap<String, BiFunction<Float, Float, EnemyShip>> _creators = new HashMap<>();

    /**
     * Registering enemy ship at the factory.
     * @param id The id of the new enemy ship
     * @param create The type of enemy ship to create
     */
    public static void registerEnemy(String id, BiFunction<Float, Float, EnemyShip> create) {
        _creators.put(id, create);
        System.out.println("Enemy registered: " + id);
    }

    /**
     * Spawns an enemy ship at given coordinates.
     * @param x The x-coordinate the enemy ship should spawn at
     * @param y The y-coordinate the enemy ship should spawn at
     * @param id The ID of the enemy ship
     * @return an enemy ship at given coordinates
     */
    public static EnemyShip spawnEnemy(float x, float y, String id) {
        if (id == null)
            return null;

        if (_instance == null || _instance.getStage() == null)
        {
            System.out.println("No enemy factory instance!");
            return null;
        }

        if (!_creators.containsKey(id))
        {
            System.out.println("Enemy unknown: " + id);
            return null;
        }
        
        EnemyShip enemy = _creators.get(id).apply(x, y);
        _instance.getStage().addActor(enemy);
        return enemy;
    }

}