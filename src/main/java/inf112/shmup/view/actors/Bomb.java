package inf112.shmup.view.actors;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Bomb extends PowerUp{
	
	float blastRadius = 100f;
	
	public Bomb(float x, float y) {
		setSprite("src/assets/Bomb_1.png");
		setPosition(x, y);
		sprite.setPosition(x, y);
	}

	@Override
	public void takeDamage(int damage) {
		Circle blastArea = new Circle(getX(), getY(), blastRadius);
		
		for(Actor a : getStage().getActors()) {
			if (a instanceof Enemy) {
				if(Intersector.overlaps(blastArea, ((Damageable)a).getSprite().getBoundingRectangle())) {
					a.remove();
				}
			}
		}
		
		remove();
	}

}
