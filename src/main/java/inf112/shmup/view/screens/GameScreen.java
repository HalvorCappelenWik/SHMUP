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
	private ArrayList<PlayerBullet> playerBullets;
	
	private final float _secondsBetweenBullets = 0.2f;
	private float _secondsSinceLastBullet = 0f;
	
	
	public GameScreen(ShmupGame game) {
		this.game = game;
		this.stage = new Stage(new FitViewport(game.V_WIDTH, game.V_HEIGHT, game.camera));
		playerBullets = new ArrayList<>();
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
		
		update(delta);
		
		stage.act(delta);

		stage.draw();
		

	}
	
	private void update(float dt) {
		// Input handling
		if(Gdx.input.isKeyPressed(Keys.LEFT))
			if(moveInBounds(-5f, 0)) 	player.moveBy(-5f, 0);
		if(Gdx.input.isKeyPressed(Keys.RIGHT))
			if(moveInBounds(5f, 0))	player.moveBy(5f, 0);
		if(Gdx.input.isKeyPressed(Keys.UP))
			if(moveInBounds(0, 5f))	player.moveBy(0, 5f);
		if(Gdx.input.isKeyPressed(Keys.DOWN))
			if(moveInBounds(0, -5f))	player.moveBy(0, -5f);
		
		// Check and remove out of bounds bullets
		ArrayList<PlayerBullet> pbCopy = new ArrayList<>(playerBullets);
		Rectangle gameBounds = new Rectangle(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		for(PlayerBullet b : pbCopy) {
			if(!gameBounds.contains(b.getSprite().getBoundingRectangle())) {
				playerBullets.remove(b);
				b.remove();
			}
		}
		
		// Spawn new bullet every 200th of a second
		if(_secondsSinceLastBullet > _secondsBetweenBullets) {
			PlayerBullet newBullet = new PlayerBullet(player.getX() + player.getWidth()/2, player.getY() + player.getHeight());
			stage.addActor(newBullet);
			playerBullets.add(newBullet);
			_secondsSinceLastBullet = 0f;
		}
		else {
			_secondsSinceLastBullet += dt;
		}
	}
	
	private boolean moveInBounds(float x, float y) {
		Rectangle gameBounds = new Rectangle(0,0,Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Rectangle playerBounds = player.getSprite().getBoundingRectangle();
		float newPlayerX = playerBounds.getX() + x;
		float newPlayerY = playerBounds.getY() + y;
		playerBounds.setX(newPlayerX);
		playerBounds.setY(newPlayerY);
		
		return gameBounds.contains(playerBounds);
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
