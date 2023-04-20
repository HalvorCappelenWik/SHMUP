package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class YellowShip3 extends Ship {

    public YellowShip3() {
        super(AssetManager.sprite("ships/ship_yellow3.png"), 8);

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
