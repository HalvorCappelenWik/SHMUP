package inf112.shmup.core.utilities;
import org.junit.jupiter.api.Test;

import inf112.shmup.core.Game;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.headless.HeadlessApplication;
import com.badlogic.gdx.backends.headless.HeadlessApplicationConfiguration;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import org.junit.jupiter.api.BeforeAll;

public class AudioPlayerTest {


    @BeforeAll
    public static void setUp() {

        Gdx.gl = mock(GL20.class);
        final HeadlessApplicationConfiguration config = new HeadlessApplicationConfiguration();
        new HeadlessApplication(new ApplicationListener() {

            @Override
            public void create() {}

            @Override
            public void resize(int width, int height) {}

            @Override
            public void render() {}

            @Override
            public void pause() {}

            @Override
            public void resume() {}

            @Override
            public void dispose() {}
            
        }, config);
    }


    @Test
    public void playbackTest(){
        assert(AudioPlayer.playEffect("powerup") != -1);
    }
}
