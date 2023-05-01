package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.BackgroundHandler;

public class MainMenuScreen implements Screen{
	
	private final Game game;
	private Stage stage;
	private Skin skin;
	private TextButton playButton;
	private BackgroundHandler background;
	
	private boolean isZoomed = false;
	private float zoomSpeed = 1.9f;
	
	
	public MainMenuScreen(final Game game) {
		this.game = game;
		this.stage = new Stage(game.getViewport());
		Gdx.input.setInputProcessor(stage);
		
		background = new BackgroundHandler("src/assets/sea_map.png", game.getViewport());
		background.setScale(4);
		
		skin = new Skin();

		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(1, 1, Format.RGBA8888);
		pixmap.setColor(Color.WHITE);
		pixmap.fill();
		skin.add("white", new Texture(pixmap));

		// Store the default libGDX font under the name "default".
		skin.add("default", new BitmapFont());

		// Configure a TextButtonStyle and name it "default". Skin resources are stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("default", textButtonStyle);
		
		
		Label title = new Label("SHMUP", new LabelStyle(game.font, Color.BLACK));
		title.setAlignment(Align.center);
		title.setY(Gdx.graphics.getHeight()*2/3);
		title.setWidth(Gdx.graphics.getWidth());
		title.setX(Game.V_WIDTH/2 - title.getWidth()/2);
		stage.addActor(title);
		
		playButton = new TextButton("PLAY!", skin);
		playButton.setWidth(Gdx.graphics.getWidth()/2);
		playButton.setPosition(Game.V_WIDTH/2-playButton.getWidth()/2, Game.V_HEIGHT/2-playButton.getHeight()/2);
        //playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
		
		playButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				isZoomed = true;
			}
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		stage.addActor(playButton);
	}
	
	private boolean scalingBackground(float delta) {
		if (delta >= 1000) {
			background.setScale(2);
			return false;
		}
		
		background.setScale(background.getScale() + (2 * (delta/1000)));
		
		return true;
	}
	

	@Override
	public void show() {
		
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
		
		background.render(delta);
		
		stage.act(delta);
		
		stage.draw();
		
		game.batch.begin();
		game.batch.end();
		
		if(isZoomed) {
			if(background.getScale() <= 2) {
				game.setScreen(new GameScreen(game));
			}
			else {
				background.setScale(background.getScale() - zoomSpeed * delta);
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		stage.getViewport().update(width, height, false);
		
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
