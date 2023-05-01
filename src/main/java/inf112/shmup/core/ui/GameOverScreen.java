package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.ScoreManager;

public class GameOverScreen implements Screen{
	private final Stage stage;
	private final Game game;
	
	public GameOverScreen(final Game game) {
		// Game object can be used to get score and etc
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);

		float top = Gdx.graphics.getHeight() / 3;
		addLabel("GAME OVER", top);
		addLabel("SCORE: " + ScoreManager.getScore(), top + 30);
	}

	private void addLabel(String text, float y) {
		Label label = new Label(text, new LabelStyle(game.font, Color.BLACK));
		label.setX(Gdx.graphics.getWidth() * 0.5f - label.getWidth() * 0.5f);
		label.setY(y);
		stage.addActor(label);
	}

	@Override
	public void show() { }

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		stage.draw();
	}

	@Override
	public void resize(int width, int height) { }

	@Override
	public void pause() { }

	@Override
	public void resume() { }

	@Override
	public void hide() { }

	@Override
	public void dispose() { }
}
