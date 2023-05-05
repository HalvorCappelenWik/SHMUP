package inf112.shmup.core;

import org.junit.jupiter.api.BeforeEach;
import static org.mockito.Mockito.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameTestBase {

    private Game _game;

    protected Game getGame() {
        return _game;
    }

    @BeforeEach
    public void setupGame() {
        // Mock GDX
    	Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);

        // Create the Game object
        Game.TEST_MODE = true;
        _game = spy(new Game());

        // Set the mock objects as dependencies of the Game object
        _game.batch = mock(SpriteBatch.class);
        _game.shape = mock(ShapeRenderer.class);
        _game.font = mock(BitmapFont.class);
        _game.camera = mock(OrthographicCamera.class);
        _game.viewport = mock(FitViewport.class);

        // Start app
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        new HeadlessApplication(_game, config);
    }
}