package inf112.shmup.core.enemies;

import com.badlogic.gdx.math.Rectangle;

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
     * Gets the bounding box for the damageable object.
    */
    Rectangle getBounds();
}