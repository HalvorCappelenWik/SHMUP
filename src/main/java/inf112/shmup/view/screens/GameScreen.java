package inf112.shmup.view.screens;

import java.util.ArrayList;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import inf112.shmup.app.ShmupGame;
import inf112.shmup.view.actors.Player;
import inf112.shmup.view.actors.PlayerBullet;

public class GameScreen implements Screen{
	
	private final ShmupGame game;
	private Stage stage;
	private Player player;

	
	
	public GameScreen(ShmupGame game) {
		this.game = game;
		this.stage = new Stage(new FitViewport(game.V_WIDTH, game.V_HEIGHT, game.camera));
		Gdx.input.setInputProcessor(stage);
		
		player = new Player();
		stage.addActor(player);
		stage.setKeyboardFocus(player);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
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
		stage.dispose();
	}
}
