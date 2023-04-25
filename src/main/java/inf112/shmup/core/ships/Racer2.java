package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Racer2 extends Ship {

    public Racer2() {
        super(AssetManager.sprite("ships/ship_green2.png"), 4);

        addRifle(0.15f, () -> new PlayerBullet(1))
            .useSound("shoot_1");

        setSpeedX(500f);
        setSpeedY(500f);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}