package inf112.shmup.core.powerups;

import com.badlogic.gdx.scenes.scene2d.Actor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;

public class PowerUpFactory extends Actor {

	private static PowerUpFactory _instance;
	private static final Random _random = new Random();
	private static final Map<String, BiFunction<Float, Float, PowerUp>> _creators = new HashMap<>();
	private static final Map<String, Double> _weights = new HashMap<>();

	/**
	 * Create a new powerUpFactory
	 */
	public PowerUpFactory() {
		_instance = this;
		registerPowerUp("bomb", 4, (x,y) -> new Bomb(x, y));
		registerPowerUp("full_heal", 2, (x, y) -> new FullHeal(x, y));
		registerPowerUp("ship_upgrade_gunship", 2, (x, y) -> new ShipUpgrade(x, y, ShipUpgrade.GUNSHIP_TYPE));
		registerPowerUp("ship_upgrade_tank", 2, (x, y) -> new ShipUpgrade(x, y, ShipUpgrade.TANK_TYPE));
		registerPowerUp("ship_upgrade_racer", 2, (x, y) -> new ShipUpgrade(x, y, ShipUpgrade.RACER_TYPE));
		registerPowerUp("ship_upgrade_rocketeer", 1, (x, y) -> new ShipUpgrade(x, y, ShipUpgrade.ROCKET_TYPE));
		registerPowerUp("fallingredbomb", 2, (x,y) -> new FallingRedBomb(x, y));
		registerPowerUp("extraHealth", 4, (x,y) -> new ExtraHealth(x,y));
		registerPowerUp("nuke", 1, (x,y) -> new AtomBomb(x,y));
	}

	/**
	 * Register a powerup to the factory
	 * @param id The id of the powerup
	 * @param weight The weight of the powerup
	 * @param create The powerup to create
	 */
	public static void registerPowerUp(String id, float weight, BiFunction<Float, Float, PowerUp> create) {
		System.out.println("PowerUp registered: " + id + "@" + weight);

		_creators.put(id, create);
		_weights.put(id, (double)weight);
	}

	/**
	 * Spawns the powerup.
	 * @param x The x-coordinate to spawn the powerup at
	 * @param y The y-coordinate to spawn the powerup at
	 */
	public static void spawnPowerUp(float x, float y) {
		spawnPowerUp(x, y, _creators.keySet());
	}

	/**
	 * Spawns a powerup with the options given, based on the weights for the powerups
	 * @param x  x position to spawn powerup on
	 * @param y  y position to spawn powerup on
	 * @param options  A Collection of strings corresponding to powerups
	 */
	public static void spawnPowerUp(float x, float y, Collection<String> options) {
		double totalWeight = options.stream().mapToDouble(PowerUpFactory::getWeight).sum();
		double randomWeight = _random.nextDouble() * totalWeight;

		for (String id : options) {
			randomWeight -= getWeight(id);

			if (randomWeight < 0) {
				spawnPowerUp(x, y, id);
				return;
			}
		}
	}

	/**
	 * Spawns a powerup with a given string id
	 * @param x  x position to spawn powerup
	 * @param y  y position to spawn powerup
	 * @param id  the string id, representing powerup type
	 */
	public static void spawnPowerUp(float x, float y, String id) {
		if (_creators.containsKey(id)) {
			PowerUp powerUp = _creators.get(id).apply(x, y);
			_instance.getStage().addActor(powerUp);
			System.out.println("PowerUp spawned: " + id);
		}
		else {
			System.out.println("PowerUp unknown: " + id);
		}
	}

	/**
	 * Returns true only x % of the time where x is yesProbability * 100
	 * @param yesProbability  a probability between 0 and 1
	 * @return  true if a random aligns with probability
	 */
	public static boolean shouldSpawnPowerUp(float yesProbability) {
		if (yesProbability >= 1)
			return true;

		if (yesProbability <= 0)
			return false;

		return yesProbability > _random.nextDouble();
	}

	private static double getWeight(String name) {
		return _weights.getOrDefault(name, 0.0);
	}

}