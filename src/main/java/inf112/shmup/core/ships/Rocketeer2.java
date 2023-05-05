package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.bullets.PlayerRocket;

public class Rocketeer2 extends Ship {

    private static final int _max_health = 4;
    private static final float _rocket_cooldown = 0.7f;
    private static final int _rocket_damage = 5;
    private static final float _bullet_cooldown = 0.65f;
    private static final int _bullet_damage = 1;
    private static final float _bullet_angle = 12f;

    /**
     * Constructor for the Rocketeer2 class.
     */
    public Rocketeer2() {
        super(AssetManager.sprite("ships/ship_red2.png"), _max_health);

        addRifle(_rocket_cooldown, () -> new PlayerRocket(_rocket_damage))
            .useSound("shoot_1");

        addRifle(_bullet_cooldown, () -> new PlayerBullet(_bullet_damage))
            .useSound("shoot_1")
            .useAngles(-_bullet_angle, _bullet_angle);
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}