package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Tank1 extends Ship {

    public Tank1() {
        super(AssetManager.sprite("ships/ship_yellow1.png"), 4);

        addRifle(0.65f, () -> new PlayerBullet(1))
                .useSound("shoot_1");
    }

    @Override
    protected void onHealed() {
        AudioPlayer.playEffect("player_killed");
    }

    @Override
    protected void onDamaged() {

    }

    @Override
    protected void onDead() {

    }
}
