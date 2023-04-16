package inf112.shmup.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import inf112.shmup.core.Game;

public class Main {
    public static void main(String[] args) {
        Lwjgl3ApplicationConfiguration cfg = new Lwjgl3ApplicationConfiguration();
        cfg.setTitle("shmup");
        cfg.setWindowedMode(1280, 960);
        cfg.setForegroundFPS(60);

        new Lwjgl3Application(new Game(), cfg);
    }
}
