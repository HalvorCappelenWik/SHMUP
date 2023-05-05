package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.bullets.PlayerRocket;

public class Rocketeer2 extends Ship {

    private static final int MAX_HEALTH = 4;
    private static final float ROCKET_COOLDOWN = 0.7f;
    private static final int ROCKET_DAMAGE = 5;
    private static final float BULLET_COOLDOWN = 0.65f;
    private static final int BULLET_DAMAGE = 1;
    private static final float BULLET_ANGLE = 12f;


    public Rocketeer2() {
        super(AssetManager.sprite("ships/ship_red2.png"), MAX_HEALTH);

        addRifle(ROCKET_COOLDOWN, () -> new PlayerRocket(ROCKET_DAMAGE))
            .useSound("shoot_1");

        addRifle(BULLET_COOLDOWN, () -> new PlayerBullet(BULLET_DAMAGE))
            .useSound("shoot_1")
            .useAngles(-BULLET_ANGLE, BULLET_ANGLE);
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}