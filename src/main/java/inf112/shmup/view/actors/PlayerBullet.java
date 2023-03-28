package inf112.shmup.view.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class PlayerBullet extends Bullet{


    public PlayerBullet(float x, float y) {
        super(x, y);
		setSprite("src/assets/bullets/bullet_a.png");
    }

// ------------------------------- Override actor methods -----------------------------------

    @Override
    protected void move(float delta) {
        moveBy(0, 2000*delta);
    }
    
    @Override
	public void act(float delta) {
		super.act(delta);
		killEnemyIfCollide();
	}

// --------------------------- Utility -----------------------------------
    
    
    /**
     * Kills any player that collides
     */
    private void killEnemyIfCollide() {
 	   Rectangle bounds = this.sprite.getBoundingRectangle();
 	   
 	   // Double check that bullet is not out of bounds
 	   if(this.getStage() == null) return;
 	   // Loop over actors
 	   for(Actor a : getStage().getActors()) {
 		   // If it is a player
 		   if(a instanceof Enemy) {
 			   // Skip dead enemies that are in death animation
 			   if(((Enemy) a).killed) {
 				   continue;
 			   }
 			   // Check collision 
 			   if(bounds.overlaps(((Enemy) a).getSprite().getBoundingRectangle())){
 				   ((Enemy) a).kill();
 				   this.remove();
 				   return;
 			   }
 		   }
 		   
 		   // Temporary code for destroying powerups
 		   
 		   if(a instanceof PowerUp) {
 			   PowerUp powerUp = (PowerUp) a;
 			   if(bounds.overlaps(powerUp.getSprite().getBoundingRectangle())) {
	 			   powerUp.takeDamage(0);
	 			   
	 			   remove();
	 			   return;
 			   }
 		   }
 	   }
    }
}
