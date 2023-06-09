package inf112.shmup.core.powerups;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class FullHeal extends PowerUp {

    /**
     * Constructor for the FullHeal class.
     * @param x The x-coordinate the full heal should spawn at
     * @param y The y-coordinate the full heal should spawn at
     */
    FullHeal(float x, float y) {
        super(x, y, AssetManager.sprite("items/health.png"));
    }

    @Override
    public void activate() {
    	Player player = Player.getInstance();
        player.getShip().takeDamage(-player.getShip().getMaxHealth());
        remove();
    }

	@Override
	public void takeDamage(int damage) {}
}

