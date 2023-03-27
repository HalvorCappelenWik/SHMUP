package inf112.shmup.view.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.app.ShmupGame;

public abstract class Bullet extends DrawableActor{

	EnemyCollection enemyFactory;
	
	public Bullet(float x, float y) {

		setPosition(x, y, Align.center);
		setSprite("src/assets/bullets/bullet_a.png");
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		positionChanged();
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		move(delta);
		Rectangle bounds = new Rectangle(0, 0, ShmupGame.V_WIDTH, ShmupGame.V_HEIGHT);
		if (!bounds.overlaps(sprite.getBoundingRectangle())) {
			this.remove();
		}
	}
	

	/**	
	 * Method for moving in the act method. Disctinct method to avoid an issue where you could not change the speed in child objects
	 */
	protected void move(float delta){
		moveBy(0, 1000);
	}	
}