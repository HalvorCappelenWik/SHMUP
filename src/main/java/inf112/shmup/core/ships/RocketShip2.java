package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerRocket;

public class RocketShip2 extends Ship {

    public RocketShip2() {

        super(AssetManager.sprite("ships/ship_red2.png"), 4);

        addRifle(0.5f, () -> new PlayerRocket(5))
            .useSound("shoot_1");
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
