package inf112.shmup.view.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.app.ShmupGame;

public class GameOverScreen implements Screen{
	private ShmupGame game;
	private Stage stage;
	
	public GameOverScreen(final ShmupGame game) {
		// Game object can be used to get score and etc
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
		Label title = new Label("GAME OVER", new LabelStyle(game.font, Color.BLACK));
		title.setAlignment(Align.center);
		title.setY(Gdx.graphics.getHeight()*2/3);
		title.setWidth(Gdx.graphics.getWidth());
		stage.addActor(title);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act();
		
		stage.draw();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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