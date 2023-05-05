package inf112.shmup.core.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class PlayerHealth extends Actor {

	Sprite spriteA;
	Sprite spriteB;
	int health;
	int maxHealth;
	int scale = 2;
	float margin = 5;
	float startX = 50;
	float startY = 50;

	/**
	 * Constructor for the PlayerHealth class.
	 */
	public PlayerHealth() {
		spriteA = AssetManager.sprite("items/heart.png");
		spriteA.setScale(scale, scale);
		spriteB = AssetManager.sprite("items/heart_missing.png");
		spriteB.setScale(scale, scale);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {

		Player player = Player.getInstance();
	

		if(player == null) return;
		health = player.getShip().getHealth();
		maxHealth = player.getShip().getMaxHealth();
		spriteA.setPosition(startX, startY);
		
		for (int i = 0; i < health; i++) {
			spriteA.draw(batch);
			spriteA.setX(spriteA.getX() + spriteA.getWidth()*scale + margin);
		}

		spriteB.setPosition(spriteA.getX(), spriteA.getY());

		for(int i = health; i < maxHealth; i++){
			
			spriteB.draw(batch);
			spriteB.setX(spriteB.getX() + spriteB.getWidth()*scale + margin);
		}
	}

}