package inf112.shmup.core.bullets;

import inf112.shmup.core.utilities.Explosion;

public abstract class Rocket extends Bullet{


    protected float _radius;

    public Rocket(float speed, String rocketSprite){
        super(speed, rocketSprite);
    }
    
    protected void spawnExplosion(float x, float y, int damage){
        Explosion explosion =  new Explosion(x, y, _radius, damage);
        getStage().addActor(explosion);
    }
}
