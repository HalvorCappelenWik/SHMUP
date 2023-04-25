package inf112.shmup.core.utilities;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;

import inf112.shmup.core.Game;

import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;

public class AssetManagerTest {
	private HeadlessApplication app;


    @BeforeAll
    public static void setUp() {
        // Initialize LibGDX with headless backend
    	Gdx.gl = mock(GL20.class);       
        Gdx.gl20 = mock(GL20.class);
    }


    @BeforeEach
    void setUpBeforeEach() {
        HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        app = new HeadlessApplication(new Game(), config);
    }
    @Test
    public void testSpriteLoading() {
        // Load a sprite using AssetManager
        Sprite sprite = AssetManager.sprite("Bomb_1.png");

        // Assert that the sprite is not null
        assertNotNull(sprite);
    }

    @Test
    public void testSoundLoading() {
        // Load a sound using AssetManager
        Sound sound = AssetManager.sound("sound.wav");

        // Assert that the sound is not null
        assertNotNull(sound);
    }

    @Test
    public void testFileHandling() {
        // Get a file handle using AssetManager
        FileHandle fileHandle = AssetManager.file("Bomb_1.png");

        // Assert that the file handle is not null
        assertNotNull(fileHandle);
    }
}