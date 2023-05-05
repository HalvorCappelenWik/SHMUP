package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerRocket;

public class Rocketeer1 extends Ship {

    private static final int MAX_HEALTH = 4;
    private static final float ROCKET_COOLDOWN = 0.7f;
    private static final int ROCKET_DAMAGE = 2;

    public Rocketeer1() {
        super(AssetManager.sprite("ships/ship_red1.png"), MAX_HEALTH);

        addRifle(ROCKET_COOLDOWN, () -> new PlayerRocket(ROCKET_DAMAGE))
            .useSound("shoot_1");
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}