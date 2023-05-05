package inf112.shmup.core.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class PlayerHealth extends Actor {

	Sprite sprite;

	/**
	 *
	 */
	public PlayerHealth() {
		sprite = AssetManager.sprite("heart.png");
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);

		Player player = Player.getInstance();

		if(player == null) return;
		sprite.setX(100);
		sprite.setY(50);
		
		for (int i = 0; i < player.getShip().getHealth(); i++) {
			sprite.draw(batch);
			sprite.setX(sprite.getX() + sprite.getWidth());
		}
	}

}