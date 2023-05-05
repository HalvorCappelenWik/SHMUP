package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Tank3 extends Ship {

    private static final int _max_health = 9;
    private static final float _bullet_cooldown = 0.65f;
    private static final int _bullet_damage = 1;
    private static final float _bullet_angle = 12f;
    private static final int _bullets_per_burst = 2;
    private static final float _burst_cooldown = 0.1f;

    /**
     * Constructor for the Tank3 class.
     */
    public Tank3() {
        super(AssetManager.sprite("ships/ship_yellow3.png"), _max_health);

        addRifle(_bullet_cooldown, () -> new PlayerBullet(_bullet_damage))
            .useSound("shoot_1")
            .useAngles(-_bullet_angle, _bullet_angle)
            .useBurst(_bullets_per_burst, _burst_cooldown);
    }

    @Override
    protected void onHealed() {
        AudioPlayer.playEffect("player_killed");
    }

    @Override
    protected void onDamaged() {}

    @Override
    protected void onDead() {}

}