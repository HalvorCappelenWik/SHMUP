package inf112.shmup.core.powerups;

import com.badlogic.gdx.graphics.g2d.Sprite;
import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;

public class ExtraHealth extends PowerUp {

    ExtraHealth(float x, float y) {
        super(x, y, AssetManager.sprite("heart.png"));
        sprite.setSize(12, 12);
    }

    @Override
    public void takeDamage(int damage) {
        Player player = Player.getInstance();
        player.getShip().takeDamage(-2);
        remove();
    }
}

