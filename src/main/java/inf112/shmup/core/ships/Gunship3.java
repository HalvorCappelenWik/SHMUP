package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Gunship3 extends Ship {

    private static final int _max_health = 4;
    private static final float _bullet_cooldown = 0.5f;
    private static final int _bullet_damage = 1;
    private static final float _bullet_angle = 12f;

    /**
     * Constructor for the Gunship3 class.
     */
    public Gunship3() {
        super(AssetManager.sprite("ships/ship_blue3.png"), _max_health);

        addRifle(_bullet_cooldown, () -> new PlayerBullet(_bullet_damage))
            .useSound("shoot_1")
            .useAngles(-_bullet_angle, 0f, _bullet_angle);
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}