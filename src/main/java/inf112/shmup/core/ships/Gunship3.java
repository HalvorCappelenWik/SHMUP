package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Gunship3 extends Ship {

    private static final int MAX_HEALTH = 4;
    private static final float BULLET_COOLDOWN = 0.5f;
    private static final int BULLET_DAMAGE = 1;
    private static final float BULLET_ANGLE = 12f;

    public Gunship3() {
        super(AssetManager.sprite("ships/ship_blue3.png"), MAX_HEALTH);

        addRifle(BULLET_COOLDOWN, () -> new PlayerBullet(BULLET_DAMAGE))
            .useSound("shoot_1")
            .useAngles(-BULLET_ANGLE, 0f, BULLET_ANGLE);
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}