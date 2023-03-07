package inf112.shmup.view.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;


public class EnemyBullet extends Bullet{

    Sprite sprite = super.sprite;

    public EnemyBullet(float x, float y) { // add Player parameter
        super(x, y);
    }

   @Override
   protected void move(float delta) {
       moveBy(0, -1000*delta);
   }
}
