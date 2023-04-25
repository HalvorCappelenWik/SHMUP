package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Racer3 extends Ship {

    public Racer3() {
        super(AssetManager.sprite("ships/ship_green3.png"), 4);

        addRifle(0.20f, () -> new PlayerBullet(1))
            .useSound("shoot_1");

        setSpeedX(650f);
        setSpeedY(650f);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}
