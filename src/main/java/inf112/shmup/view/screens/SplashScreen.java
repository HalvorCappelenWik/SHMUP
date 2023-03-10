package inf112.shmup.view.screens;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.alpha;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeIn;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

import inf112.shmup.app.ShmupGame;

public class SplashScreen implements Screen {

	private final ShmupGame game;
	private final Stage stage;
	private final Image splashImage;
	

	public SplashScreen(final ShmupGame game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);

		Texture splashTexture = new Texture(Gdx.files.internal("javaJunkiesLogo.png"));
		splashImage = new Image(splashTexture);
		splashImage.setOrigin(splashImage.getWidth() / 2, splashImage.getHeight() / 2);

		stage.addActor(splashImage);
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		// Fiks dette!
		RunnableAction run = new RunnableAction();
		run.setRunnable(new Runnable() {
		    @Override
		    public void run() {
		        game.setScreen(new MainMenuScreen(game));;
		    }
		});
		splashImage.setPosition(ShmupGame.V_WIDTH / 2 - splashImage.getWidth(), ShmupGame.V_HEIGHT / 2 - splashImage.getHeight());
		splashImage.addAction(sequence(alpha(.1f), fadeIn(3f), run));
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		update(delta);

		stage.draw();

		game.batch.begin();
		game.batch.end();
	}

	public void update(float delta) {
		stage.act(delta);

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