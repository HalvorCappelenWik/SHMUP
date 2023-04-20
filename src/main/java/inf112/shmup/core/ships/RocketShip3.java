package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerRocket;

public class RocketShip3 extends Ship {

    public RocketShip3() {

        super(AssetManager.sprite("ships/ship_red3.png"), 4);

        addRifle(0.5f, () -> new PlayerRocket(5))
            .useSound("shoot_1")
            .useAngles(-12f, 0f, 12f);
        }

    @Override
    protected void onHealed() {
    }

    @Override
    protected void onDamaged() {
    }

    @Override
    protected void onDead() {

    }
    
}