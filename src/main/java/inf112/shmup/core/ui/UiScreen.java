package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;

public abstract class UiScreen implements Screen {

	protected Game game;
	protected Stage stage;
	protected Skin skin;

	/**
	 * Constructor for the UiScreen class.
	 * @param game The game being played
	 */
	public UiScreen(final Game game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin(AssetManager.file("skin/sgx-ui.json"));
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(delta);
		
		stage.draw();
	}
	
	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
	}
	
	@Override
	public void dispose() {
		stage.dispose();
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
	public void hide() {
		// TODO Auto-generated method stub
	}

}