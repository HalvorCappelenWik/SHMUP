package inf112.shmup.core.enemies;

import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.EnemyBullet;
import inf112.shmup.core.powerups.PowerUpFactory;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Grunt1 extends EnemyShip {

    private float _speed = 100;
    private int _dir = 1;

    public Grunt1(float x, float y) {
        super(x, y, AssetManager.sprite("ships/ship_1.png"), 1);

        addRifle(1f, () -> new EnemyBullet(1));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        clampToScreen();

        moveBy(_dir * _speed * delta, 0);

        if (getX() < 0) {
            _dir = 1;
        } else if (getX() + getWidth() > Game.V_WIDTH) {
            _dir = -1;
        }
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { 
		AudioPlayer.playEffect("enemy_killed");
        if (PowerUpFactory.shouldSpawnPowerUp(0.33f)) {
            PowerUpFactory.spawnPowerup(getX(), getY());
        } else {
            System.out.println("Did not spawn powerup");
        }
    }
    
}
