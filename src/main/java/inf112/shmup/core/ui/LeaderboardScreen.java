package inf112.shmup.core.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.ScoreRecord;
import inf112.shmup.core.utilities.ScoreboardManager;

public class LeaderboardScreen extends UiScreen{

	public LeaderboardScreen(Game game) {
		super(game);
		ScoreboardManager.initialize();
	}

	@Override
	public void show() {
		Table table = new Table(skin);
		stage.addActor(table);
		
		table.setPosition(Game.V_WIDTH / 2 - (table.getWidth() / 2), Game.V_HEIGHT / 2 - (table.getHeight() / 2));
		
		Label title = new Label("TOP 10 SCORES:", skin);
		table.add(title);
		
		table.row();
		
		for(ScoreRecord score : ScoreboardManager.getTopTenScores()) {
			Label scoreLabel = new Label(score.toString(), skin);
			table.add(scoreLabel);
			table.row();
		}
		
		TextButton backButton = new TextButton("BACK", skin);
		
		backButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				game.setScreen(new MainMenuScreen(game));
			}
			
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		backButton.setColor(MainMenuScreen.defaultColor);
		table.add(backButton);
	}

}
