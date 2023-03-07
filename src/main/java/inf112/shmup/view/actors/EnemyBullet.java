package inf112.shmup.view.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class EnemyBullet extends Bullet{

    Sprite sprite = super.sprite;

    public EnemyBullet(float x, float y) { // add Player parameter
        super(x, y);
    }

   @Override
   protected void move(float delta) {
       moveBy(0, -1000*delta);
       sprite.setBounds(getX(), getY(), getWidth(), getHeight());
   }
   
   @Override
   public void act(float delta) {
   	super.act(delta);
   	killPlayerIfCollide();
   }
   
   
   /**
    * Kills any player that collides
    */
   private void killPlayerIfCollide() {
	   Rectangle bounds = this.sprite.getBoundingRectangle();
	   
	   // Double check that bullet is not out of bounds
	   if(this.getStage() == null) return;
	   // Loop over actors
	   for(Actor a : getStage().getActors()) {
		   // If it is a player
		   if(a instanceof Player) {
			   // Check collision 
			   if(bounds.overlaps(((Player) a).getSprite().getBoundingRectangle())){
				   ((Player) a).kill();
				   this.remove();
				   return;
			   }
		   }
	   }
   }
   
}
