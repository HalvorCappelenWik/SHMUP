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
import inf112.shmup.util.WaveManager;
import inf112.shmup.view.actors.Enemy;
import inf112.shmup.view.actors.EnemyFactory;
import inf112.shmup.view.actors.Player;
import inf112.shmup.view.actors.PlayerBullet;

public class GameScreen implements Screen{
	
	private final ShmupGame game;
	private Stage stage;
	private Player player;
	private EnemyFactory enemyFactory;
	
	// Keep track of enemy waves
	int waveNum = 0;
	WaveManager waveManager;
	
	
	public GameScreen(ShmupGame game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
		enemyFactory = new EnemyFactory(new ArrayList<>(), stage);
		stage.addActor(enemyFactory);
		
		player = new Player(ShmupGame.V_WIDTH/2-200, 100);
		stage.addActor(player);
		stage.setKeyboardFocus(player);
		
		this.waveManager = new WaveManager("src/assets/levels/testLevel.json");
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
		
		// Check if player is killed
		if(player.killed) {
			player.remove();
			dispose();
			game.setScreen(new GameOverScreen(game));
		}
		
		// Check if all waves are killed
		if(waveNum > waveManager.waveNums) {
			dispose();
			game.setScreen(new GameOverScreen(game));
		}
		
		// If no enemies then spawn next wave
		if(getEnemiesInStage().isEmpty()) {
			try {
				addEnemiesToStage(waveManager.getWave(waveNum));
				waveNum += 1;
			} catch(IndexOutOfBoundsException e) {
				dispose();
				game.setScreen(new GameOverScreen(game));
			}
		}

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
	public EnemyFactory getEnemyFactory(){	//Currently pointless, thought .getScene was .getScreen.
		return this.enemyFactory;			//Which would have allowed me to access tbe factory from any actor
	}
	
	/**
	 * Makes a list of all (not killed) enemies currently in the stage
	 * @return list of alive enemies
	 */
	private List<Enemy> getEnemiesInStage(){
		List<Enemy> enemies = new ArrayList<>();
		
		for(Actor a : stage.getActors()) {
			if (a instanceof Enemy && !((Enemy) a).killed) {
				enemies.add((Enemy) a);
			}
		}
		
		return enemies;
	}
	
	/**
	 * Adds all enemies in list to stage
	 * @param enemies  List of enemies
	 */
	private void addEnemiesToStage(List<Enemy> enemies) {
		for(Enemy e : enemies) {
			stage.addActor(e);
		}
	}
}
