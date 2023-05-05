package inf112.shmup.core.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class AssetManager {

    /**
     * Load a sprite from assets folder.
     * @param name Relative path to sprite in assets folder.
     * @return Loaded sprite.
     */
    public static Sprite sprite(String name)
    {
        return new Sprite(new Texture(file(name)));
    }

    /**
     * Load a sound from assets folder.
     * @param name Relative path to sound in assets folder.
     * @return Loaded sound.
     */
    public static Sound sound(String name) {
        return Gdx.audio.newSound(file(name));
    }

    /**
     * Gets a file handle to file in assets folder.
     * @param name Relative file in assets folder.
     * @return A handle to the file.
     */
    public static FileHandle file(String name) {
        return new FileHandle("src/assets/" + name);
    }

}