package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class GunshipSpeed3 extends Ship {

    float speed1x = 750f;
    float speed1y = 750f;
    
    public GunshipSpeed3() {
        super(AssetManager.sprite("ships/ship_green3.png"), 4);

        addRifle(0.5f, () -> new PlayerBullet(1))
            .useSound("shoot_1")
            .useAngles(-12f, 0f, 12f);

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
