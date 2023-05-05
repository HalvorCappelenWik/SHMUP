package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Racer3 extends Ship {

    private static final int MAX_HEALTH = 4;
    private static final float BULLET_COOLDOWN = 0.2f;
    private static final int BULLET_DAMAGE = 1;
    private static final float SHIP_SPEED = 650f;

    public Racer3() {
        super(AssetManager.sprite("ships/ship_green3.png"), MAX_HEALTH);

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