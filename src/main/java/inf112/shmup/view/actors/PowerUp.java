package inf112.shmup.view.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

public abstract class PowerUp extends DrawableActor implements Damageable{
	

	@Override
	public void act(float delta) {
		super.act(delta);
		moveBy(0, -0.5f);
		
		if(collidesWithPlayer()) takeDamage(0);
	}
	
	@Override
	protected void positionChanged() {
		// TODO Auto-generated method stub
		super.positionChanged();
		sprite.setX(getX(Align.center) - sprite.getWidth()/2);
		sprite.setY(getY(Align.center) - sprite.getHeight()/2);
	}



	private boolean collidesWithPlayer() {
		Rectangle bounds = sprite.getBoundingRectangle();
		
		if (getStage() == null)
			return false;

		for(Actor a : getStage().getActors()) {
			if (a instanceof Player) {
				if (bounds.overlaps(((Player) a).getSprite().getBoundingRectangle())) {
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		// TODO Auto-generated method stub
		super.draw(batch, parentAlpha);
		sprite.draw(batch);
	}

	@Override
	public Rectangle getBounds() {
		return sprite.getBoundingRectangle();
	}
}