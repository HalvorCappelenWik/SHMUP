package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Racer1 extends Ship {
    
    public Racer1() {
        super(AssetManager.sprite("ships/ship_green1.png"), 4);

        addRifle(0.35f, () -> new PlayerBullet(1))
            .useSound("shoot_1");
            
        setSpeedX(400f);
        setSpeedY(400f);
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}