package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Gunship3 extends Ship {
    
    public Gunship3() {
        super(AssetManager.sprite("ships/ship_blue3.png"), 4);

        addRifle(0.5f, () -> new PlayerBullet(1))
            .useSound("shoot_1")
            .useAngles(-12f, 0f, 12f);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}