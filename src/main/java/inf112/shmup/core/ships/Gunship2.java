package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;

public class Gunship2 extends Ship {

    private static final int MAX_HEALTH = 4;
    private static final float BULLET_COOLDOWN = 0.65f;
    private static final int BULLET_DAMAGE = 1;
    
    public Gunship2() {
        super(AssetManager.sprite("ships/ship_blue2.png"), MAX_HEALTH);

        addRifle(BULLET_COOLDOWN, () -> new PlayerBullet(BULLET_DAMAGE))
            .useSound("shoot_1")
            .useAngles(-10f, 10f);
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}