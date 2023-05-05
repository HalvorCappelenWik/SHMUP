package inf112.shmup.core.enemies;

import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.EnemyBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Grunt2 extends EnemyShip {

    private static final int MAX_HEALTH = 5;
    private static final int BULLET_DAMAGE = 1;
    private float _speed = 200;
    private int _dir = 1;

    public Grunt2(float x, float y) {
        super(x, y, AssetManager.sprite("ships/ship_8.png"), MAX_HEALTH);

        addRifle(0.7f, () -> new EnemyBullet(BULLET_DAMAGE))
            .useSound("shoot_2")
            .useAngles(10f, -10f);
        
        this.killPoints = 200;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getActions().size != 0) return;
        clampToScreen();

        moveBy(_dir * _speed * delta, 0);

        if (getX() < 0) {
            _dir = 1;
        } else if (getX() + getWidth() > Game.V_WIDTH) {
            _dir = -1;
        }
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

}