package inf112.shmup.view.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;


public class PlayerBullet extends Bullet{

    Sprite sprite =  super.sprite;

    public PlayerBullet(float x, float y) {
        super(x, y);
    }

    @Override
    protected void move(float delta) {
        moveBy(0, 2000*delta);
    }
}
