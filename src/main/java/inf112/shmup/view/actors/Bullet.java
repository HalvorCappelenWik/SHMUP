package inf112.shmup.view.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.app.ShmupGame;

public class Bullet extends Actor{
	
	Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/laserBlue02.png")));

	float speed = 2000;
	int vrt_direction = 1;
	
	public Bullet(float x, float y) {
		sprite.setOriginCenter();
		//sprite.setScale(1, 1);
		setOrigin(getTotalWidth(), getTotalHeight());
		setBounds(x, y, sprite.getWidth() * sprite.getScaleX(), sprite.getHeight() * sprite.getScaleY());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.setPosition(getX(), getY());
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		this.moveBy(0, vrt_direction*speed*delta);
		Rectangle bounds = new Rectangle(0, 0, ShmupGame.V_WIDTH, ShmupGame.V_HEIGHT);
		if (!bounds.overlaps(sprite.getBoundingRectangle())) {
			this.remove();
		}
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
}