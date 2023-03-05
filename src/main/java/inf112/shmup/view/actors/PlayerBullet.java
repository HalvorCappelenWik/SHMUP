package inf112.shmup.view.actors;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerBullet extends Actor{
	
	private final Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/laserBlue02.png")));
	
	
	public PlayerBullet(float x, float y) {
		setBounds(x, y, sprite.getWidth(), sprite.getHeight());
	}
	
	@Override
	protected void positionChanged() {
		sprite.setPosition(getX(), getY());
		super.positionChanged();
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		sprite.draw(batch);
	}

	@Override
	public void act(float delta) {
		this.moveBy(0, 5f);
	}
	
	public Sprite getSprite() {
		return sprite;
	}

}
