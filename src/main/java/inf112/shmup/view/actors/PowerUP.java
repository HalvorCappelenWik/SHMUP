package inf112.shmup.view.actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class PowerUP extends DrawableActor implements Damageable{
	
	Sprite sprite;


	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(0, -3);
		
		if(collidesWithPlayer()) takeDamage(0);
	}
	
	private boolean collidesWithPlayer() {
		Rectangle bounds = sprite.getBoundingRectangle();
		
		for(Actor a : getStage().getActors()) {
			if (a instanceof Player) {
				if (bounds.overlaps(((Player) a).getSprite().getBoundingRectangle())) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	
}
