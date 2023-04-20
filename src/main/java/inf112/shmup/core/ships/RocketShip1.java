package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerRocket;

public class RocketShip1 extends Ship {

    public RocketShip1() {

        super(AssetManager.sprite("ships/ship_red1.png"), 4);

        addRifle(0.5f, () -> new PlayerRocket(2))
            .useSound("shoot_1");
        }

    @Override
    protected void onHealed() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onHealed'");
    }

    @Override
    protected void onDamaged() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onDamaged'");
    }

    @Override
    protected void onDead() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onDead'");
    }
    
}
