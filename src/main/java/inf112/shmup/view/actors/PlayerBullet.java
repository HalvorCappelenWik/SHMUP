package inf112.shmup.view.actors;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

import inf112.shmup.app.ShmupGame;

public class PlayerBullet extends Bullet{

    Sprite sprite =  super.sprite;

    public PlayerBullet(float x, float y) {
        super(x, y);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
