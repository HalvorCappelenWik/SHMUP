package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Tank3 extends Ship {

    public Tank3() {
        super(AssetManager.sprite("ships/ship_yellow3.png"), 9);

        addRifle(0.65f, () -> new PlayerBullet(1))
            .useSound("shoot_1")
            .useAngles(-12f, 12f)
            .useBurst(2, 0.1f);
    }

    @Override
    protected void onHealed() {
        AudioPlayer.playEffect("player_killed");
    }

    @Override
    protected void onDamaged() { }

    @Override
    protected void onDead() { }
}