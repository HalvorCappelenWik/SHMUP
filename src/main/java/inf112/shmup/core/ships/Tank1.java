package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Tank1 extends Ship {

    private static final int _max_health = 5;
    private static final float _bullet_cooldown = 0.65f;
    private static final int _bullet_damage = 1;

    /**
     * Constructor for the Tank1 class.
     */
    public Tank1() {
        super(AssetManager.sprite("ships/ship_yellow1.png"), _max_health);

        addRifle(_bullet_cooldown, () -> new PlayerBullet(_bullet_damage))
            .useSound("shoot_1");
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