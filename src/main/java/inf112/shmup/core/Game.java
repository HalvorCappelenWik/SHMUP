package inf112.shmup.core;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import inf112.shmup.core.ui.SplashScreen;
import inf112.shmup.core.utilities.AssetManager;

public class Game extends com.badlogic.gdx.Game {
	
	public static boolean TEST_MODE = false;
	public static final boolean DEBUG_ENABLED = false;
	public static final String TITLE = "Shmup";
	public static final int V_WIDTH = 800;
	public static final int V_HEIGHT = 800;
	public static final JsonValue CONFIG = new JsonReader().parse(AssetManager.file("config.json"));
	
	Viewport viewport;

	public OrthographicCamera camera;
	public SpriteBatch batch;
	public ShapeRenderer shape;

	public BitmapFont font;
	
	@Override
	public void create() {
		if (TEST_MODE)
			return;

		camera = new OrthographicCamera(V_WIDTH, V_HEIGHT);
		camera.setToOrtho(false, V_WIDTH, V_HEIGHT);

		//keeps track of the aspect ratio of the game
		viewport = new FitViewport(V_WIDTH, V_HEIGHT, camera);

		
		shape = new ShapeRenderer(); //allows us to draw primitives
		batch = new SpriteBatch();
		font = new BitmapFont();
        
        // this.setScreen(new MainMenuScreen(this));
		this.setScreen(new SplashScreen(this));
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
	public void dispose() {
        batch.dispose();
        this.getScreen().dispose();
	}

}