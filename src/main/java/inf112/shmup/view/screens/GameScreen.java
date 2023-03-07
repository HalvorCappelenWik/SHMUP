package inf112.shmup.view.screens;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;

import inf112.shmup.app.ShmupGame;
import inf112.shmup.view.actors.Enemy;
import inf112.shmup.view.actors.EnemyFactory;
import inf112.shmup.view.actors.Player;
import inf112.shmup.view.actors.PlayerBullet;

public class GameScreen implements Screen{
	
	private final ShmupGame game;
	private Stage stage;
	private Player player;
	private EnemyFactory enemyFactory;
	
	public GameScreen(ShmupGame game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
		enemyFactory = new EnemyFactory(new ArrayList<>(), stage);
		stage.addActor(enemyFactory);
		
		player = new Player(ShmupGame.V_WIDTH/2, 100);
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

		//draw background rectangle using shapeRenderer
		game.shape.setProjectionMatrix(game.camera.combined);
		game.shape.begin(ShapeType.Filled);
		game.shape.setColor(Color.LIGHT_GRAY);
		game.shape.rect(0, 0, ShmupGame.V_WIDTH, ShmupGame.V_WIDTH);
		game.shape.end();


		stage.act(delta);

		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		game.resizeViewport(width, height);
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

	// --------- other methods ----------

	/**
	 * @return Enemyfactory object in scene
	 */
	public EnemyFactory getEnemyFactory(){
		return this.enemyFactory;
	}
}
