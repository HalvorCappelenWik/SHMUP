package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
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

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class OptionsScreen implements Screen{
	
	private Game game;
	private Stage stage;
	private Skin skin;

	public OptionsScreen(final Game game) {
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
		
		Label title = new Label("OPTIONS", skin);
		title.setColor(MainMenuScreen.defaultColor);
		table.add(title).colspan(3);
		
		table.row();
		
		Label effectsVolumeSliderLabel = new Label("Effects volume", skin);
		effectsVolumeSliderLabel.setColor(MainMenuScreen.defaultColor);
		table.add(effectsVolumeSliderLabel).width(effectsVolumeSliderLabel.getWidth());
		
		Label effectsVolumeLabel = new Label(Float.toString(Math.round(AudioPlayer.effectVolume * 100)) + "%", skin);
		effectsVolumeLabel.setColor(MainMenuScreen.defaultColor);
		
		Slider effectsVolumeSlider = new Slider(0, 1, 0.001f, false, skin);
		effectsVolumeSlider.setColor(MainMenuScreen.defaultColor);
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
		
		table.row();
		
		Label emptyLabel = new Label("", skin);
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
