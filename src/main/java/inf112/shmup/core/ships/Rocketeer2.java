package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.bullets.PlayerRocket;

public class Rocketeer2 extends Ship {

    public Rocketeer2() {
        super(AssetManager.sprite("ships/ship_red2.png"), 4);

        addRifle(0.7f, () -> new PlayerRocket(5))
            .useSound("shoot_1");

        addRifle(0.65f, () -> new PlayerBullet(1))
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