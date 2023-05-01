package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;
import inf112.shmup.core.utilities.BackgroundHandler;

public class MainMenuScreen implements Screen{
	
	private final Game game;
	private Stage stage;
	private Skin skin;
	private BackgroundHandler background;
	
	private boolean isZoomed = false;
	private float zoomSpeed = 1f;
	
	
	public MainMenuScreen(final Game game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
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
		title.setColor(Color.GREEN);
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
		
		playButton.setColor(Color.GREEN);
		table.add(playButton).colspan(3).width(400);
		
		table.row();

		Label effectsVolumeSliderLabel = new Label("Effects volume", skin);
		table.add(effectsVolumeSliderLabel).width(effectsVolumeSliderLabel.getWidth());
		
		Label effectsVolumeLabel = new Label(Float.toString(AudioPlayer.effectVolume * 100) + "%", skin);
		
		Slider effectsVolumeSlider = new Slider(0, 1, 0.001f, false, skin);
		effectsVolumeSlider.setValue(AudioPlayer.effectVolume);
		effectsVolumeSlider.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				AudioPlayer.effectVolume = effectsVolumeSlider.getValue();
				effectsVolumeLabel.setText(Float.toString(Math.round(AudioPlayer.effectVolume * 100)) + "%");
			}
		});
		table.add(effectsVolumeSlider);
		
		
		table.add(effectsVolumeLabel).width(60);
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
		stage.dispose();
		
	}

}
