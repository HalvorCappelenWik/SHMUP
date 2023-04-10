package inf112.shmup.util;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class AudioPlayer {
    private static final HashMap<String, Sound> _sounds = new HashMap<>();

    public static void playEffect(String soundName) {

        Sound sound = _sounds.get(soundName);

        if (sound == null) {
            sound = Assets.sound("sounds/" + soundName + ".wav");
            _sounds.put(soundName, sound);
        }

        sound.play();
    }
}
