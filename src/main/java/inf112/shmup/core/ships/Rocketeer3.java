package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.bullets.PlayerRocket;

public class Rocketeer3 extends Ship {

    public Rocketeer3() {

        super(AssetManager.sprite("ships/ship_red3.png"), 4);

        addRifle(0.6f, () -> new PlayerRocket(5))
            .useSound("shoot_1");

        addRifle(0.5f, () -> new PlayerBullet(1))
            .useSound("shoot_1")
            .useAngles(12f, -12f);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}