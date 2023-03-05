package inf112.shmup.view.actors;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;

public class Player extends Actor{
	Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/playerShip1_blue.png")));
	
	public Player() {
		setBounds(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
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
		super.act(delta);
	}
	
	

}
