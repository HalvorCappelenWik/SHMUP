package inf112.shmup.core.utilities;

public class ScoreManager {

	private static int score = 0;
	
	// Multiplier variable for the possible extension where score can be multiplied before adding to total score.
	private static float multiplier = 1;
	
	/**
	 * Add to the score, is multiplied with multiplier before adding to the score.
	 * @param score The score points to be added
	 */
	public static void addScore(int scoreAdd) {
		score += scoreAdd * multiplier;
	}
	
	/**
	 * Get the current total score.
	 * @return the total score
	 */
	public static int getScore() {
		return score; 
	}
	
	/**
	 * Set the score multiplier.
	 * @param mult The new multiplier
	 */
	public static void setMultiplier(float mult) {
		multiplier = mult;
	}
	
	/**
	 * Get the current score multiplier.
	 * @return the multiplier
	 */
	public static float getMultiplier() {
		return multiplier;
	}

}