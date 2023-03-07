package inf112.shmup.view.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.app.ShmupGame;

public abstract class Bullet extends Actor{
	
	Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/laserBlue02.png")));

	EnemyFactory enemyFactory;
	
	public Bullet(float x, float y) {
		sprite.setOriginCenter();
		//sprite.setScale(1, 1);
		setOrigin(getTotalWidth()/2, getTotalHeight()/2);
		setBounds(x, y, getTotalWidth(), getTotalHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.setPosition(getX(), getY());
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		move(delta);
		Rectangle bounds = new Rectangle(0, 0, ShmupGame.V_WIDTH, ShmupGame.V_HEIGHT);
		if (!bounds.overlaps(sprite.getBoundingRectangle())) {
			this.remove();
		}
		killEnemyIfCollide();
	}

	/**	
	 * Method for moving in the act method. Disctinct method to avoid an issue where you could not change the speed in child objects
	 */
	protected void move(float delta){
		moveBy(0, 1000);
	}

	/**
	 * @return Total width with scale
	 */
	public float getTotalWidth(){
		return sprite.getWidth() * sprite.getScaleX();
	}

	/**
	 * @return Total height with scale
	 */
	public float getTotalHeight(){
		return sprite.getHeight() * sprite.getScaleY();
	}
	
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
			   // Check collision 
			   if(bounds.overlaps(((Enemy) a).getSprite().getBoundingRectangle())){
				   ((Enemy) a).setKilled();
				   this.remove();
				   a.remove();
				   return;
			   }
		   }
	   }
   }
}