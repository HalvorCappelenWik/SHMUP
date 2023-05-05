package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Racer1 extends Ship {

    private static final int _max_health = 3;
    private static final float _bullet_cooldown = 0.35f;
    private static final int _bullet_damage = 1;
    private static final float _ship_speed = 450f;

    /**
     * Constructor for the Racer1 class.
     */
    public Racer1() {
        super(AssetManager.sprite("ships/ship_green1.png"), _max_health);

        addRifle(_bullet_cooldown, () -> new PlayerBullet(_bullet_damage))
            .useSound("shoot_1");
            
        setSpeedX(_ship_speed);
        setSpeedY(_ship_speed);
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}