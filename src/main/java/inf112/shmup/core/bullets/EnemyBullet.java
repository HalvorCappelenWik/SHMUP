package inf112.shmup.core.bullets;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;


public class EnemyBullet extends Bullet {

    private final int _damage;

    public EnemyBullet(float x, float y, int damage) {
        
        super(x, y);
        _damage = damage;
        setSprite(AssetManager.sprite("bullets/bullet_c.png"));
        setPosition(x, y, Align.center);
        setEnemyRotation(sprite);
    }

// ------------------------------- Override actor methods -----------------------------------

   @Override
   protected void move(float delta) {
       moveBy(0, -500*delta);
       //sprite.setBounds(getX(), getY(), getTotalWidth(), getTotalHeight());
   }
   
   @Override
   public void act(float delta) {
   	    super.act(delta);
   	    damagePlayerIfCollide();
   }


// --------------------------- Utility -----------------------------------
   
   
   /**
    * Kills any player that collides
    */
    private void damagePlayerIfCollide() {
	    Rectangle bounds = this.sprite.getBoundingRectangle();
	   
	    // Double check that bullet is not out of bounds
	    if (this.getStage() == null) return;

        Player player = Player.getInstance();
        if (player == null) return;
       
        // Check collision 
        if (bounds.overlaps(player.getSprite().getBoundingRectangle())) {
            player.takeDamage(_damage);
            this.remove();
            return;
        }
    }
}