package inf112.shmup.core.powerups;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class ExtraHealth extends PowerUp {

    ExtraHealth(float x, float y) {
        super(x, y, AssetManager.sprite("heart.png"));
        sprite.setSize(13, 13);
    }

    @Override
    public void activate() {
        Player player = Player.getInstance();
        player.getShip().takeDamage(-2);
        remove();
    }

	@Override
	public void takeDamage(int damage) {
		return;
	}
}

