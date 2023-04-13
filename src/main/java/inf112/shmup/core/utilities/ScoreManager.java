package inf112.shmup.core.utilities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.ShmupGame;
import inf112.shmup.core.ui.GameScore;

public class ScoreManager extends Actor {
	
	BitmapFont font = new BitmapFont();

	@Override
	public void act(float delta) {
		// GameScore.addScore(1);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, "SCORE: " + GameScore.getScore(), 10, ShmupGame.V_HEIGHT - 10);
	}

}