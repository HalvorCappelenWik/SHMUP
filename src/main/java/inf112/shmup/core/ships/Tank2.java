package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Tank2 extends Ship {

    public Tank2() {
        super(AssetManager.sprite("ships/ship_yellow2.png"), 6);

        addRifle(0.65f, () -> new PlayerBullet(1))
                .useSound("shoot_1");
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