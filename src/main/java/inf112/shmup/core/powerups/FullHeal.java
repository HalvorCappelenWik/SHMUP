package inf112.shmup.core.powerups;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class FullHeal extends PowerUp {

    // Should one be able to shoot the FullHeal to get the PowerUp?
    // Seems wonky? Should it be collision only?

    FullHeal(float x, float y) {
        setSprite(AssetManager.sprite("no_sprite.png")); // Add FullHeal sprite!
        setPosition(x, y);
        sprite.setPosition(x, y);
    }

    @Override
    public void takeDamage(int damage) {
    	Player player = Player.getInstance();
        player.takeDamage(-player.getMaxHealth());
        remove();
    }
}