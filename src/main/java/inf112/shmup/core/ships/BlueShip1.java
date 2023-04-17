package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class BlueShip1 extends Ship {
    
    public BlueShip1() {
        super(AssetManager.sprite("ships/ship_blue1.png"), 3);

        addRifle(0.65f, () -> new PlayerBullet(1));
    }

    @Override
    protected void onDamaged() {
		AudioPlayer.playEffect("player_killed");
    }

    @Override
    protected void onHealed() { }

    @Override
    protected void onDead() { }
}