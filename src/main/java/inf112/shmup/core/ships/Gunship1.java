package inf112.shmup.core.ships;

import inf112.shmup.core.bullets.PlayerBullet;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class Gunship1 extends Ship {

    private static final int MAX_HEALTH = 3;
    private static final float BULLET_COOLDOWN = 0.65f;
    private static final int BULLET_DAMAGE = 1;
    
    public Gunship1() {
        super(AssetManager.sprite("ships/ship_blue1.png"), MAX_HEALTH);

        addRifle(BULLET_COOLDOWN, () -> new PlayerBullet(BULLET_DAMAGE))
            .useSound("shoot_1");
    }

    @Override
    protected void onDamaged() {
        AudioPlayer.playEffect("player_killed");
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDead() {}

}