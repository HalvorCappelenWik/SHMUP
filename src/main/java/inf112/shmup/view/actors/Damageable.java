package inf112.shmup.view.actors;

/**
 * Actor that can take damage by the player.
 */
public interface Damageable {

    /**
     * Damages the actor by some amount.
     * @param damage the amount of damage
     */
    void takeDamage(int damage);

}