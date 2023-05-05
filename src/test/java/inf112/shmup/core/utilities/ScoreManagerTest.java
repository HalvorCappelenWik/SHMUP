package inf112.shmup.core.utilities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreManagerTest extends GameTestBase {
	
	@BeforeEach
	public void setUp() {
		ScoreManager.setMultiplier(1); // Reset multiplier before each test
		ScoreManager.addScore(-ScoreManager.getScore()); // Reset score before each test
	}
	
	@Test
	public void testAddScore() {
		ScoreManager.addScore(100);
		assertEquals(100, ScoreManager.getScore());
	}
	
	@Test
	public void testAddScoreWithMultiplier() {
		ScoreManager.setMultiplier(2);
		ScoreManager.addScore(100);
		assertEquals(200, ScoreManager.getScore());
	}

	@Test
	public void testAddZeroScore() {
		ScoreManager.addScore(0);
		assertEquals(0, ScoreManager.getScore());
	}
	
	@Test
	public void testAddNegativeScore() {
	    ScoreManager.addScore(-50);
	    assertEquals(-50, ScoreManager.getScore());
	}
	
	@Test
	public void testGetMultiplier() {
		ScoreManager.setMultiplier(0.5f);
		assertEquals(0.5f, ScoreManager.getMultiplier(), 0.001); // Use delta for float comparison
	}
	
	@Test
	public void testSetMultiplier() {
		ScoreManager.setMultiplier(1.5f);
		assertEquals(1.5f, ScoreManager.getMultiplier(), 0.001); // Use delta for float comparison
	}

}