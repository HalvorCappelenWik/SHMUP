package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class GunshipSpeed1 extends Ship {
    
    float speed1x = 450f;
    float speed1y = 450f;

    public GunshipSpeed1() {
        super(AssetManager.sprite("ships/ship_green1.png"), 4);

        addRifle(0.5f, () -> new PlayerBullet(1))
            .useSound("shoot_1");
    


        setSpeedX(speed1x);
        setSpeedY(speed1y);
    
    }


    @Override
    protected void onHealed() { }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }

    
    
}