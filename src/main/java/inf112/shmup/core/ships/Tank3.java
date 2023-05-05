package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Tank3 extends Ship {

    private static final int MAX_HEALTH = 9;
    private static final float BULLET_COOLDOWN = 0.65f;
    private static final int BULLET_DAMAGE = 1;
    private static final float BULLET_ANGLE = 12f;
    private static final int BULLETS_PER_BURST = 2;
    private static final float BURST_COOLDOWN = 0.1f;

    public Tank3() {
        super(AssetManager.sprite("ships/ship_yellow3.png"), MAX_HEALTH);

        addRifle(BULLET_COOLDOWN, () -> new PlayerBullet(BULLET_DAMAGE))
            .useSound("shoot_1")
            .useAngles(-BULLET_ANGLE, BULLET_ANGLE)
            .useBurst(BULLETS_PER_BURST, BURST_COOLDOWN);
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