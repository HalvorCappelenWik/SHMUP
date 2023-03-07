package inf112.shmup.app;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import inf112.shmup.view.screens.MainMenuScreen;

public class ShmupGame extends Game{
	
	public static final String TITLE = "Shmup";
	public static final int V_WIDTH = 800;
	public static final int V_HEIGHT = 800;
	
	private Viewport viewport;

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public ShapeRenderer shape;

	public BitmapFont font;
	
	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, V_WIDTH, V_HEIGHT);

		//keeps track of the aspect ratio of the game
		viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);

		
		shape = new ShapeRenderer(); //allows us to draw primitives
		batch = new SpriteBatch();
		font = new BitmapFont();
        
        this.setScreen(new MainMenuScreen(this));
	}

	/**
	 * Resize the viewport | Remember to include in resize function in scene
	 * @param width width input in resize function
	 * @param height width input in resize function
	 */
	public void resizeViewport(float width, float height){
		viewport.update((int) width, (int) height);
	}

	public Viewport getViewport(){
		return viewport;
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
        this.getScreen().dispose();
	}

}
