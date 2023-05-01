package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;

public class AboutScreen implements Screen{
	
	private Game game;
	private Stage stage;
	private Skin skin;
	
	public AboutScreen(final Game game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
		skin = new Skin(AssetManager.file("skin/sgx-ui.json"));
	}

	@Override
	public void show() {
		Table table = new Table(skin);
		stage.addActor(table);
		
		//table.setDebug(true); // turn on all debug lines (table, cell, and widget)
		table.setPosition(Game.V_WIDTH / 2 - (table.getWidth() / 2), Game.V_HEIGHT / 2 - (table.getHeight() / 2));
		
		Label title = new Label("ABOUT", skin);
		title.setColor(MainMenuScreen.defaultColor);
		title.setFontScale(1.5f);
		table.add(title);
		
		table.row();
		
		Label emptyLabel = new Label("", skin);
		table.add(emptyLabel).height(50);
		
		table.row();
		
		Label controlKeysLabel = new Label("You control your spaceships with the arrow keys!", skin);
		controlKeysLabel.setColor(MainMenuScreen.defaultColor);
		table.add(controlKeysLabel);
		
		table.row();
		
		Image arrowKeysImage = new Image(new Texture(AssetManager.file("direction_keys.png")));
		table.add(arrowKeysImage).size(100,100);
		
		table.row();
		
		emptyLabel = new Label("", skin);
		table.add(emptyLabel).height(Game.V_HEIGHT/5);
		
		table.row();
		
		TextButton backButton = new TextButton("BACK", skin);
		
		backButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				game.setScreen(new MainMenuScreen(game));
			}
			
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		backButton.setColor(MainMenuScreen.defaultColor);
		table.add(backButton).colspan(3);
		
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

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
