package inf112.shmup.core.enemies;

import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.EnemyBomb;
import inf112.shmup.core.bullets.EnemyBullet;
import inf112.shmup.core.powerups.PowerUpFactory;
import inf112.shmup.core.ships.Rifle;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Bomber1 extends EnemyShip {

    private final float _speed = 100;
    private final Rifle _rifle;
    private static final float _angle = 45;
    private int _dir = 1;

    public Bomber1(float x, float y) {
        super(x, y, AssetManager.sprite("ships/ship_3.png"), 5);

        _rifle = addRifle(3f, () -> new EnemyBomb(_speed)).useSound("shoot_2").useAngles(_angle); // Change sounds
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getActions().size != 0) return;
        clampToScreen();

        moveBy(_dir * _speed * delta, 0);

        if (getX() < 0) {
            _dir = 1;
            //_rifle.useAngles(_angle);
        } else if (getX() + getWidth() > Game.V_WIDTH) {
            _dir = -1;
            //_rifle.useAngles(-_angle);
        }

        setRotation(90 * -_dir);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { 
		AudioPlayer.playEffect("enemy_killed");
        if (PowerUpFactory.shouldSpawnPowerUp(0.6f)) {
            PowerUpFactory.spawnPowerUp(getX(), getY());
        }
    }
    
}