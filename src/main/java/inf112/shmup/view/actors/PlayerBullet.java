package inf112.shmup.view.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerBullet extends Actor{
	
	private final Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/laserBlue02.png")));
	
	public PlayerBullet(float x, float y) {
		setBounds(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.setPosition(getX(), getY());
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		this.moveBy(0, 5f);
		Rectangle bounds = new Rectangle(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if (!bounds.contains(sprite.getBoundingRectangle())) {
			this.remove();
		}
	}
}