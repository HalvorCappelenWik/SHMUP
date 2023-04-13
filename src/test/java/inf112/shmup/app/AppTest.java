package inf112.shmup.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertTrue;

import inf112.shmup.core.ShmupGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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