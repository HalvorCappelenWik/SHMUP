package inf112.shmup.core;

import static org.mockito.Mockito.*;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    private Game game;
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;
    private BitmapFont bitmapFont;
    private OrthographicCamera camera;
    private Viewport viewport;

    @BeforeEach
    public void setUp() {
        // Create mock objects for dependencies
        spriteBatch = mock(SpriteBatch.class);
        shapeRenderer = mock(ShapeRenderer.class);
        bitmapFont = mock(BitmapFont.class);
        camera = mock(OrthographicCamera.class);
        viewport = mock(FitViewport.class);

        // Create the Game object
        Game.TEST_MODE = true;
        game = spy(new Game());

        // Set the mock objects as dependencies of the Game object
        game.batch = spriteBatch;
        game.shape = shapeRenderer;
        game.font = bitmapFont;
        game.camera = camera;
        game.viewport = viewport;
    }

    @Test
    public void testResizeViewport() {
        // Call the resizeViewport() method on the game object with mock arguments
        game.resizeViewport(100f, 200f);

        // Verify that the viewport is updated with the correct arguments
        verify(viewport).update(100, 200);
    }

    @Test
    public void testDispose() {
        // Create a mock Screen object
        Screen screen = mock(Screen.class);

        // Set the mock Screen object as the current screen of the game object
        when(game.getScreen()).thenReturn(screen);

        // Call the dispose() method on the game object
        game.dispose();

        // Verify that the batch is disposed and the screen's dispose() method is called
        verify(spriteBatch).dispose();
        verify(screen).dispose();
    }
}
