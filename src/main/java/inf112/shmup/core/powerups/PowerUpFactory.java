package inf112.shmup.core.powerups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import inf112.shmup.core.enemies.Enemy;

public class PowerUpFactory {
	// NEEDS TO BE EDITED AS WE IMPLEMENT MORE POWERUPS!!!!
	static List<String> availablePowerUps = new ArrayList<>(Arrays.asList("Bomb", "FullHeal"));
	
	
	/**
	 * 
	 * @return
	 */
	public static PowerUp nextPowerUp(Enemy enemy) {
		PowerUp powerUp = null;
		
		Random rand = new Random();
		
		if(rand.nextInt(3) == 0) {
			String powerUpString = availablePowerUps.get(rand.nextInt(availablePowerUps.size()));
			
			if (powerUpString == "Bomb") powerUp = new Bomb(enemy.getX(), enemy.getY());
			
			if (powerUpString == "FullHeal") powerUp = new FullHeal(enemy.getX(), enemy.getY());
			
			// if (powerUpString == "") powerUp = new (enemy.getX(), enemy.getY());
			
			// if (powerUpString == "") powerUp = new (enemy.getX(), enemy.getY());
		}
		
		return powerUp;
	}

}
