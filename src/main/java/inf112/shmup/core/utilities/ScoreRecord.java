package inf112.shmup.core.utilities;

import java.math.BigDecimal;

public class ScoreRecord {
	private String username;
	private BigDecimal score;
	
	public ScoreRecord(String username, BigDecimal score) {
		this.username = username;
		this.score = score;
	}

	public String getUsername() {
		return username;
	}

	public BigDecimal getScore() {
		return score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return username + ": " + score.toString();
	}
	
	
}
