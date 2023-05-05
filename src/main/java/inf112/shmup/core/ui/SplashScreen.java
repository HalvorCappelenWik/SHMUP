package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import inf112.shmup.core.Game;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class SplashScreen extends UiScreen {

	private final Image splashImage;

	public SplashScreen(final Game game) {
		super(game);

		Texture splashTexture = new Texture(Gdx.files.internal("src/assets/javaJunkiesLogo.png"));
		splashImage = new Image(splashTexture);
		splashImage.setOrigin(splashImage.getWidth() / 2, splashImage.getHeight() / 2);

		stage.addActor(splashImage);
	}

	@Override
	public void show() {
		RunnableAction run = new RunnableAction();
		run.setRunnable(new Runnable() {
		    @Override
		    public void run() {
		        game.setScreen(new MainMenuScreen(game));;
		    }
		});
		splashImage.setPosition(Game.V_WIDTH / 2 - splashImage.getWidth()/2, Game.V_HEIGHT / 2 - splashImage.getHeight()/2);
		splashImage.addAction(sequence(alpha(.1f), fadeIn(3f), run));
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//draw background rectangle using shapeRenderer
		game.shape.setProjectionMatrix(game.camera.combined);
		game.shape.begin(ShapeRenderer.ShapeType.Filled);
		game.shape.setColor(Color.WHITE);
		game.shape.rect(0, 0, Game.V_WIDTH, Game.V_WIDTH);
		game.shape.end();

		stage.act(delta);

		stage.draw();

		game.batch.begin();
		game.batch.end();
	}

}