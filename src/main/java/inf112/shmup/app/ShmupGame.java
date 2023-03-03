package inf112.shmup.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import inf112.shmup.view.screens.MainMenuScreen;

public class ShmupGame extends Game{
	
	public static final String TITLE = "Shmup";
	public static final int V_WIDTH = 1000;
	public static final int V_HEIGHT = 1000;
	
	public OrthographicCamera camera;
	public SpriteBatch batch;

	public BitmapFont font;
	
	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, V_WIDTH, V_HEIGHT);
		
		batch = new SpriteBatch();
		font = new BitmapFont();
        
        this.setScreen(new MainMenuScreen(this));
	}

	@Override
	public void render() {
		super.render();
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
        batch.dispose();
	}

}
