package inf112.shmup.core.enemies;

import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.EnemyBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Grunt1 extends EnemyShip {

    private static final int _max_health = 2;
    private static final float _bullet_cooldown = 1f;
    private static final int _bullet_damage = 1;

    private float _speed = 100;
    private int _dir = 1;

    /**
     * The constructor for the Grunt1 class.
     * @param x The x-coordinate the Grunt1 plane starts at
     * @param y The y-coordinate the Grunt1 plane starts at
     */
    public Grunt1(float x, float y) {
        super(x, y, AssetManager.sprite("ships/ship_10.png"), _max_health);

        addRifle(_bullet_cooldown, () -> new EnemyBullet(_bullet_damage))
            .useSound("shoot_2");
        
        this.killPoints = 50;
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