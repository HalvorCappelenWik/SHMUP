package inf112.shmup.view.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Actor that can take damage by the player.
 */
public interface Damageable {

    /**
     * Damages the actor by some amount.
     * @param damage the amount of damage
     */
    void takeDamage(int damage);
    
    /**
     * Get the sprite of the object
     * @return
     */
    Sprite getSprite();

}