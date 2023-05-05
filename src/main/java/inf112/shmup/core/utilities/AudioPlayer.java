package inf112.shmup.core.utilities;

import com.badlogic.gdx.audio.Sound;

import java.util.HashMap;

public class AudioPlayer {
	
	public static float effectVolume = 1f;
	
    private static final HashMap<String, Sound> _sounds = new HashMap<>();

    /**
     * Play sound effect.
     * @param name Name of sound effect
     */
    public static long playEffect(String name) {

        Sound sound = _sounds.get(name);

        if (sound == null) {
            sound = AssetManager.sound("sounds/" + name + ".wav");
            _sounds.put(name, sound);
        }

        return sound.play(effectVolume);
    }

}