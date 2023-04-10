package inf112.shmup.util;

import java.io.File;
import java.nio.file.Path;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Assets {
    public static Sprite sprite(String name)
    {
        return new Sprite(new Texture(file(name)));
    }

    public static Sound sound(String name) {
        return Gdx.audio.newSound(file(name));
    }

    private static FileHandle file(String name)
    {
        return new FileHandle("src/assets/" + name);
    }
}
