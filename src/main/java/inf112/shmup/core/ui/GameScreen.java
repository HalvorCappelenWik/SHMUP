package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.shmup.core.Game;
import inf112.shmup.core.Player;
import inf112.shmup.core.enemies.EnemyFactory;
import inf112.shmup.core.enemies.EnemyShip;
import inf112.shmup.core.powerups.PowerUpFactory;
import inf112.shmup.core.utilities.BackgroundHandler;
import inf112.shmup.core.utilities.ScoreManager;
import inf112.shmup.core.utilities.WaveFactory;

import java.util.ArrayList;
import java.util.List;

public class GameScreen implements Screen {
	
	private final Game game;
	private final Stage stage;
	private final Player player;

	// Enable background
	Boolean backgroundEnabled = true;
	BackgroundHandler background;
	

	/**
	 * Constructor for the GameScreen class
	 * @param game The game being played
	 */
	public GameScreen(Game game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);

		background = new BackgroundHandler("sea_map.png", game.getViewport());
		
		player = new Player(Game.V_WIDTH/2, 100);
		stage.addActor(player);
		stage.setKeyboardFocus(player);

		stage.addActor(new PowerUpFactory());
		stage.addActor(new EnemyFactory());
		stage.addActor(new GameScore());
		stage.addActor(new PlayerHealth());
		
		WaveFactory.reset();
		WaveFactory.spawnNextWave();
		
		ScoreManager.addScore(-ScoreManager.getScore());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Check if player is killed
		if (player.getShip().isDead()) {
			game.setScreen(new GameOverScreen(game));
		}
		
		// If no enemies then spawn next wave
		if (getEnemiesInStage().isEmpty()) {
			WaveFactory.spawnNextWave();
		}

		// Render background
		if (backgroundEnabled) {
			background.render(delta);
		}

		// Stage rendering
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
		game.resizeViewport(width, height);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	// --------- Other methods ----------

	/**
	 * Makes a list of all (not killed) enemies currently in the stage
	 * @return list of alive enemies
	 */
	private List<EnemyShip> getEnemiesInStage(){
		List<EnemyShip> enemies = new ArrayList<>();
		
		for(Actor a : stage.getActors()) {
			if (a instanceof EnemyShip && !((EnemyShip) a).isDead()) {
				enemies.add((EnemyShip) a);
			}
		}
		
		return enemies;
	}

	@Override
	public void show() {
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

}