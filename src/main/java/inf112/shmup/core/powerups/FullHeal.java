package inf112.shmup.core.powerups;

import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class FullHeal extends PowerUp {

    // Should one be able to shoot the FullHeal to get the PowerUp?
    // Seems wonky? Should it be collision only?

    Player player;

    FullHeal(float x, float y) {
        setSprite(AssetManager.sprite("no_sprite.png")); // Add FullHeal sprite!
        setPosition(x, y);
        sprite.setPosition(x, y);
    }

    @Override
    public void takeDamage(int damage) {
    	player = getPlayer();
        player.takeDamage(-player.getMaxHealth());
    }
    
    private Player getPlayer() {
		// Loop over actors
		for(Actor a : getStage().getActors()) {
			// If it is a player
			if(a instanceof Player) {
			// Check collision
				return (Player) a;
			}
		}
		return null;
	}

}