package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Racer2 extends Ship {

    private static final int MAX_HEALTH = 3;
    private static final float BULLET_COOLDOWN = 0.25f;
    private static final int BULLET_DAMAGE = 1;
    private static final float SHIP_SPEED = 550f;

    public Racer2() {
        super(AssetManager.sprite("ships/ship_green2.png"), MAX_HEALTH);

        addRifle(BULLET_COOLDOWN, () -> new PlayerBullet(BULLET_DAMAGE))
            .useSound("shoot_1");

        setSpeedX(SHIP_SPEED);
        setSpeedY(SHIP_SPEED);
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}