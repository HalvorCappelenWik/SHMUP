package inf112.shmup.core.utilities;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import inf112.shmup.core.GameTestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AssetManagerTest extends GameTestBase {

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