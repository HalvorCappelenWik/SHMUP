package inf112.shmup.view.screens;

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
import com.badlogic.gdx.utils.viewport.FitViewport;

import inf112.shmup.app.ShmupGame;

public class MainMenuScreen implements Screen{
	
	private final ShmupGame game;
	private Stage stage;
	private Skin skin;
	
	
	public MainMenuScreen(final ShmupGame game) {
		this.game = game;
		this.stage = new Stage(new FitViewport(game.V_WIDTH, game.V_HEIGHT, game.camera));
		
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
		stage.addActor(title);
		
		final TextButton playButton = new TextButton("PLAY!", skin);
		playButton.setWidth(Gdx.graphics.getWidth()/2);
        playButton.setPosition(Gdx.graphics.getWidth()/2-playButton.getWidth()/2,Gdx.graphics.getHeight()/2-playButton.getHeight()/2);
		
		playButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				game.setScreen(new GameScreen(game));
			}
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		stage.addActor(playButton);
	}
	

	@Override
	public void show() {
		Gdx.input.setInputProcessor(stage);
		//stage.clear();
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(.25f, .25f, .25f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		stage.act(delta);
		
		stage.draw();
		
		game.batch.begin();
		game.batch.end();
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
