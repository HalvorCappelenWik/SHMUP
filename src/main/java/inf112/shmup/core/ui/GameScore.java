package inf112.shmup.core.ui;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.ScoreManager;

public class GameScore extends Actor {
	
	BitmapFont font = new BitmapFont();

	@Override
	public void act(float delta) {
		// GameScore.addScore(1);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, "SCORE: " + ScoreManager.getScore(), 10, Game.V_HEIGHT - 10);
	}

}