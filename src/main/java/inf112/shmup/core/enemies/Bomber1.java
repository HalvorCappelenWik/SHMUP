package inf112.shmup.core.enemies;

import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.EnemyBomb;
import inf112.shmup.core.ships.Rifle;
import inf112.shmup.core.utilities.AssetManager;

public class Bomber1 extends EnemyShip {

    private static final int _max_health = 5;

    private final float _speed = 100;
    private final Rifle _rifle;
    private static final float _angle = 55;
    private int _dir = 1;

    /**
     * Constructor for the Bomber1 class.
     * @param x The x-coordinate the Bomber plane starts at
     * @param y The y-coordinate the Bomber plane starts at
     */
    public Bomber1(float x, float y) {
        super(x, y, AssetManager.sprite("ships/ship_2.png"), _max_health);

        _rifle = addRifle(3f, () -> new EnemyBomb(_speed + 20)).useSound("shoot_2").useAngles(-_angle + 180); // Change sounds
        
        this.killPoints = 100;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getActions().size != 0) return;
        clampToScreen();

        moveBy(_dir * _speed * delta, 0);

        if (getX() < 0) {
            _dir = 1;
            _rifle.useAngles(-_angle + 180);
        } else if (getX() + getWidth() > Game.V_WIDTH) {
            _dir = -1;
            _rifle.useAngles(_angle + 180);
        }

        setRotation(90 * -_dir);
    }

    @Override
    protected void onHealed() {
        // Nothing
    }

    @Override
    protected void onDamaged() {}

}