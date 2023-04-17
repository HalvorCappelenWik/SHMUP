package inf112.shmup.core.ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.shmup.core.utilities.BackgroundHandler;
import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.EnemyFactory;
import inf112.shmup.core.enemies.EnemyShip;
import inf112.shmup.core.Player;

public class GameScreen implements Screen {
	
	private final Game game;
	private final Stage stage;
	private final Player player;

	// Keep track of enemy waves
	private final EnemyFactory enemyFactory;
	private int currentWave = 0;

	//enable background
	Boolean backgroundEnabled = true;
	BackgroundHandler background;
	
	public GameScreen(Game game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);

		background = new BackgroundHandler("src/assets/sea_map.png", game.getViewport());
		
		player = new Player(Game.V_WIDTH/2, 100);
		stage.addActor(player);
		stage.setKeyboardFocus(player);
		
		enemyFactory = new EnemyFactory("src/assets/levels/testLevel.json");
		createNextWave();
		
		stage.addActor(new GameScore());
		stage.addActor(new PlayerHealth());
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//draw background rectangle using shapeRenderer
		game.shape.setProjectionMatrix(game.camera.combined);
		game.shape.begin(ShapeType.Filled);
		game.shape.setColor(Color.LIGHT_GRAY);
		game.shape.rect(0, 0, Game.V_WIDTH, Game.V_WIDTH);
		game.shape.end();

		
		// Check if player is killed
		if(player.getShip().isDead()) {
			game.setScreen(new GameOverScreen(game));
		}
		
		// If no enemies then spawn next wave
		if(getEnemiesInStage().isEmpty()) {
			createNextWave();
		}

		//render background
		if(backgroundEnabled){
			background.render(delta);
		}

		//stage rendering
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

	private void createNextWave() {
		List<EnemyShip> newEnemies = enemyFactory.createWave(currentWave++);
		for(EnemyShip enemy : newEnemies) {
			stage.addActor(enemy);
		}
	}

	// --------- other methods ----------

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
