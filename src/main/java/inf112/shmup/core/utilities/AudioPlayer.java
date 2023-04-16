package inf112.shmup.core.utilities;

import java.util.HashMap;

import com.badlogic.gdx.audio.Sound;

public class AudioPlayer {
    private static final HashMap<String, Sound> _sounds = new HashMap<>();

    /**
     * Play sound effect.
     * @param name Name of sound effect.
     */
    public static void playEffect(String name) {

        Sound sound = _sounds.get(name);

        if (sound == null) {
            sound = AssetManager.sound("sounds/" + name + ".wav");
            _sounds.put(name, sound);
        }

        sound.play();
    }
}
