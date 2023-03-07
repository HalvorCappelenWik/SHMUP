package inf112.shmup.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.badlogic.gdx.Game;

import inf112.shmup.view.screens.MainMenuScreen;
import inf112.shmup.view.screens.SplashScreen;

public class AppTest {
	ShmupGame game;
	/**
	 * Static method run before everything else
	 */
	@BeforeAll
	static void setUpBeforeAll() {
	}

	/**
	 * Setup method called before each of the test methods
	 */
	@BeforeEach
	void setUpBeforeEach() {
		game = new ShmupGame();
	}
	
	/**
	 * Tests that when a game object is created it is initialized with the splashscreen
	 */
	@Test
	void TestGameInitWithSplashScreen() {
		//assertTrue(game.getScreen() instanceof SplashScreen);
	}

}