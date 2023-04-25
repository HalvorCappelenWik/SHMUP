package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Racer2 extends Ship {

    public Racer2() {
        super(AssetManager.sprite("ships/ship_green2.png"), 3);

        addRifle(0.25f, () -> new PlayerBullet(1))
            .useSound("shoot_1");

        setSpeedX(550f);
        setSpeedY(550f);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}