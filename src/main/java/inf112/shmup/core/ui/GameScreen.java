package inf112.shmup.core.ui;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import inf112.shmup.core.utilities.BackgroundHandler;
import inf112.shmup.core.utilities.ScoreManager;
import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.WaveManager;
import inf112.shmup.core.enemies.Enemy;
import inf112.shmup.core.Player;

public class GameScreen implements Screen{
	
	private final Game game;
	private Stage stage;
	private Player player;

	// Keep track of enemy waves
	int waveNum = 0;
	WaveManager waveManager;

	//enable background
	Boolean backgroundEnabled = true;
	BackgroundHandler background = new BackgroundHandler("shmup_map.png");
	
	public GameScreen(Game game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
		player = new Player(Game.V_WIDTH/2, 100);
		stage.addActor(player);
		stage.setKeyboardFocus(player);
		
		this.waveManager = new WaveManager("src/assets/levels/testLevel.json");
		addEnemiesToStage(waveManager.getWave(0));
		waveNum += 1;
		
		stage.addActor(new GameScore());
		 
		stage.addActor(new PlayerHealth());
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
		game.shape.rect(0, 0, Game.V_WIDTH, Game.V_WIDTH);
		game.shape.end();

		
		// Check if player is killed
		if(player.killed) {
			game.setScreen(new GameOverScreen(game));
		}
		
		// Check if all waves are killed
		if(waveNum > waveManager.waveCount) {
			game.setScreen(new GameOverScreen(game));
		}
		
		// If no enemies then spawn next wave
		if(getEnemiesInStage().isEmpty()) {
			try {
				addEnemiesToStage(waveManager.getWave(waveNum));
				waveNum += 1;
			} catch(IndexOutOfBoundsException e) {
				game.setScreen(new GameOverScreen(game));
			}
		}

		//render background
		if(backgroundEnabled){
			background.render(delta);
		}

		//stage rendering

		stage.act(delta);

		stage.draw();

		
		// use for debugging, bounding box of objects
		/*
		for(Actor a : stage.getActors()){
			if(a instanceof DrawableActor){
				DrawableActor aa = (DrawableActor) a;
				game.shape.setProjectionMatrix(game.camera.combined);
				game.shape.begin(ShapeType.Line);
				game.shape.setColor(Color.RED);
				Rectangle rect = aa.getSprite().getBoundingRectangle();
				game.shape.rect(rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight());
				game.shape.end();

				game.shape.setProjectionMatrix(game.camera.combined);
				game.shape.begin(ShapeType.Line);
				game.shape.setColor(Color.BLUE);
				game.shape.rect(aa.getX(), aa.getY(), aa.getWidth(), aa.getHeight());
				game.shape.end();

				game.shape.setProjectionMatrix(game.camera.combined);
				game.shape.begin(ShapeType.Filled);
				game.shape.setColor(Color.LIME);
				game.shape.rect(aa.getX() - 2, aa.getY() - 2, 4, 4);
				game.shape.end();
			}
		} 
		*/
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