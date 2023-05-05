package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.BackgroundHandler;

public class MainMenuScreen extends UiScreen{
	
	private BackgroundHandler background;
	public static Color defaultColor = Color.GREEN;
	
	private boolean isZoomed = false;
	private float zoomSpeed = 1f;

	public MainMenuScreen(final Game game) {
		super(game);
		
		background = new BackgroundHandler("src/assets/sea_map.png", game.getViewport());
		background.setScale(2.5f);
		
		skin = new Skin(AssetManager.file("skin/sgx-ui.json"));
	}

	@Override
	public void show() {
		
		Table table = new Table(skin);
		stage.addActor(table);
		
		//table.setDebug(true); // turn on all debug lines (table, cell, and widget)
		table.setPosition(Game.V_WIDTH / 2 - (table.getWidth() / 2), Game.V_HEIGHT / 2 - (table.getHeight() / 2));
		//table.top();
		
		Label title = new Label("SHMUP", skin);
		title.setColor(defaultColor);
		table.add(title).colspan(3);
		
		table.row();
		
		TextButton playButton = new TextButton("PLAY!", skin);
		
		playButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				isZoomed = true;
			}
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		playButton.setColor(defaultColor);
		table.add(playButton).colspan(3).width(400);
		
		table.row();
		
		TextButton optionsButton = new TextButton("OPTIONS", skin);
		
		optionsButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				game.setScreen(new OptionsScreen(game));
			}
			
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		optionsButton.setColor(defaultColor);
		
		table.add(optionsButton).width(200);
		
		TextButton aboutButton = new TextButton("ABOUT", skin);
		
		aboutButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				game.setScreen(new AboutScreen(game));
			}
			
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		aboutButton.setColor(defaultColor);
		
		table.add(aboutButton).width(200);
		
		table.row();
		
		TextButton quitButton = new TextButton("QUIT", skin);
		
		quitButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				Gdx.app.exit();
			}
			
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		quitButton.setColor(defaultColor);
		
		table.add(quitButton).colspan(2);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		//draw background rectangle using shapeRenderer
		//game.shape.setProjectionMatrix(game.camera.combined);
		//game.shape.begin(ShapeType.Filled);
		//game.shape.setColor(Color.LIGHT_GRAY);
		//game.shape.rect(0, 0, Game.V_WIDTH, Game.V_WIDTH);
		//game.shape.end();
		
		background.render(delta);
		
		stage.act(delta);
		
		stage.draw();

		
		game.batch.begin();
		game.batch.end();
		
		if(isZoomed) {
			if(background.getScale() <= 2) {
				game.setScreen(new GameScreen(game));
			}
			else {
				background.setScale(background.getScale() - zoomSpeed * delta);
			}
		}
	}

}