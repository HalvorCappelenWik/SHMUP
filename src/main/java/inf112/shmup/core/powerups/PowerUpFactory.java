package inf112.shmup.core.powerups;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.function.BiFunction;

import com.badlogic.gdx.scenes.scene2d.Actor;

public class PowerUpFactory extends Actor {
	private static PowerUpFactory _instance;
	private static final Random _random = new Random();
	private static final Map<String, BiFunction<Float, Float, PowerUp>> _creators = new HashMap<>();
	private static final Map<String, Double> _weights = new HashMap<>();

	public PowerUpFactory() {
		_instance = this;
		registerPowerUp("bomb", 2, (x,y) -> new Bomb(x, y));
		registerPowerUp("full_heal", 1, (x, y) -> new FullHeal(x, y));
	}

	public static void registerPowerUp(String name, float weight, BiFunction<Float, Float, PowerUp> create) {
		System.out.println("Registered powerup \"" + name + "\" with weight \"" + weight + '"');

		_creators.put(name, create);
		_weights.put(name, (double)weight);
	}

	public static void spawnPowerup(float x, float y) {
		spawnPowerUp(x, y, _creators.keySet());
	}

	public static void spawnPowerUp(float x, float y, Collection<String> options) {
		double totalWeight = options.stream().mapToDouble(PowerUpFactory::getWeight).sum();
		double randomWeight = _random.nextDouble() * totalWeight;

		for (String name : options) {
			randomWeight -= getWeight(name);

			if (randomWeight < 0) {
				spawnPowerUp(x, y, name);
				return;
			}
		}
	}

	public static void spawnPowerUp(float x, float y, String name) {
		PowerUp powerUp = _creators.get(name).apply(x, y);
		_instance.getStage().addActor(powerUp);
		System.out.println("Spawned " + name);
	}

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