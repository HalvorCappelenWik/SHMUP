package inf112.shmup.core.bullets;

import inf112.shmup.core.utilities.Explosion;

public abstract class Rocket extends Bullet {

    protected float _radius;

    /**
     * Constructor for the Rocket class.
     * @param speed The movement speed of the rocket
     * @param rocketSprite The sprite of the rocket
     */
    public Rocket(float speed, String rocketSprite){
        super(speed, rocketSprite);
    }

    /**
     * Spawns an explosion coming from the rocket.
     * @param x The desired x-coordinate of the explosion
     * @param y The desired y-coordinate of the explosion
     * @param damage The damage that the explosion should deal
     */
    protected void spawnExplosion(float x, float y, int damage){
        Explosion explosion =  new Explosion(x, y, _radius, damage, false);

        if (getStage() != null)
            getStage().addActor(explosion);
    }

}