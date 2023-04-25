package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Gunship2 extends Ship {
    
    public Gunship2() {
        super(AssetManager.sprite("ships/ship_blue2.png"), 4);

        addRifle(0.65f, () -> new PlayerBullet(1))
            .useSound("shoot_1")
            .useAngles(-10f, 10f);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}