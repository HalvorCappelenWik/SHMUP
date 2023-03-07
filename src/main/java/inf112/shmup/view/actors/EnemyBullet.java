package inf112.shmup.view.actors;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import inf112.shmup.app.ShmupGame;

public class EnemyBullet extends Bullet{

    Sprite sprite = super.sprite;

    int vrt_direction = -1;

    public EnemyBullet(float x, float y, Player player) {
        super(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
