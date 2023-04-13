package inf112.shmup.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inf112.shmup.core.ui.GameScore;

public class GameScoreTest {
	
	@BeforeEach
	public void setUp() {
		GameScore.setMultiplier(1); // Reset multiplier before each test
		GameScore.addScore(-GameScore.getScore()); // Reset score before each test
	}
	
	@Test
	public void testAddScore() {
		GameScore.addScore(100);
		assertEquals(100, GameScore.getScore());
	}
	
	@Test
	public void testAddScoreWithMultiplier() {
		GameScore.setMultiplier(2);
		GameScore.addScore(100);
		assertEquals(200, GameScore.getScore());
	}
	
	@Test
	public void testAddNegativeScore() {
	    GameScore.addScore(-50);
	    assertEquals(-50, GameScore.getScore());
	}
	
	@Test
	public void testGetMultiplier() {
		GameScore.setMultiplier(0.5f);
		assertEquals(0.5f, GameScore.getMultiplier(), 0.001); // Use delta for float comparison
	}
	
	@Test
	public void testSetMultiplier() {
		GameScore.setMultiplier(1.5f);
		assertEquals(1.5f, GameScore.getMultiplier(), 0.001); // Use delta for float comparison
	}
}