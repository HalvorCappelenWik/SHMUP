package inf112.shmup.core.powerups;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class FullHeal extends PowerUp {

    // Should one be able to shoot the FullHeal to get the PowerUp?
    // Seems wonky? Should it be collision only?

    FullHeal(float x, float y) {
        setSprite(AssetManager.sprite("health.png")); // Add FullHeal sprite!
        setPosition(x, y);
        sprite.setPosition(x, y);
    }

    @Override
    public void takeDamage(int damage) {
    	Player player = Player.getInstance();
        if (player.getHealth() >= 0) // This should probably not be here...
            player.takeDamage(-(player.getMaxHealth() - player.getHealth()));
        remove();
    }
}