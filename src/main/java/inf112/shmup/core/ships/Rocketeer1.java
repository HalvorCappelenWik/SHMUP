package inf112.shmup.core.ships;

import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.bullets.PlayerRocket;

public class Rocketeer1 extends Ship {

    private static final int _max_health = 4;
    private static final float _rocket_cooldown = 0.7f;
    private static final int _rocket_damage = 2;

    /**
     * Constructor for the Rocketeer1 class.
     */
    public Rocketeer1() {
        super(AssetManager.sprite("ships/ship_red1.png"), _max_health);

        addRifle(_rocket_cooldown, () -> new PlayerRocket(_rocket_damage))
            .useSound("shoot_1");
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}