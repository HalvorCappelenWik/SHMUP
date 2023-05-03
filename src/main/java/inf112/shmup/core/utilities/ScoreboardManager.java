package inf112.shmup.core.utilities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.shephertz.app42.paas.sdk.java.App42API;
import com.shephertz.app42.paas.sdk.java.game.Game;
import com.shephertz.app42.paas.sdk.java.game.ScoreBoardService;
import com.shephertz.app42.paas.sdk.java.user.User;
import com.shephertz.app42.paas.sdk.java.user.UserService;

public class ScoreboardManager {
	static ScoreBoardService scoreBoardService;
	static String gameName = "shmup";

	/**
	 * Initialize the App42API
	 * NEEDS TO BE DONE BEFORE USING ANYTHING ELSE
	 */
	public static void initialize() {
	    App42API.initialize("6bad223925cf4beee69f351d4815dab1f361a80a5537188a97ac723df2926d84","0d3194c576b86298335688562547200f3f24413429923532c1f0a6e30164287f");
	    scoreBoardService = App42API.buildScoreBoardService();
	}
	
	/**
	 * Saves the username and score in scoreboard database
	 * @param userName  for user to be saved
	 * @param score  for the latest game played
	 */
	public static void saveScoreForUser(String userName, int score) {
		BigDecimal gameScore = new BigDecimal(score);
		Game game = scoreBoardService.saveUserScore(gameName, userName, gameScore);;
		System.out.println("gameName is " + game.getName());  
		for(int i = 0;i<game.getScoreList().size();i++)  
		{  
		    System.out.println("userName is : " + game.getScoreList().get(i).getUserName());  
		    System.out.println("score is : " + game.getScoreList().get(i).getValue());  
		    System.out.println("scoreId is : " + game.getScoreList().get(i).getScoreId());  
		}   
	}
	
	/**
	 * Gets the top ten ranking users with their score
	 * @return A list of ScoreRecord objects in decreasing order
	 */
	public static List<ScoreRecord> getTopTenScores(){
		List<ScoreRecord> topTen = new ArrayList<>();
		
		// Gets the top 10 rankers
		Game game = scoreBoardService.getTopNRankers(gameName, 10);
		
		for(int i = 0;i<game.getScoreList().size();i++) {
			String username = game.getScoreList().get(i).getUserName();
			BigDecimal score = game.getScoreList().get(i).getValue();
			topTen.add(new ScoreRecord(username, score));
		}
		
		return topTen;
	}
}
