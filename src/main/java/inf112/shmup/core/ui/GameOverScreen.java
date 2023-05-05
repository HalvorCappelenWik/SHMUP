package inf112.shmup.core.ui;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.ScoreManager;

public class GameOverScreen extends UiScreen{
	
	/**
	 * Constructor for the GameOverScreen class
	 * @param game The game being played
	 */
	public GameOverScreen(final Game game) {
		super(game);
	}

	@Override
	public void show() {
		Table table = new Table(skin);
		stage.addActor(table);
		
		table.setPosition(Game.V_WIDTH / 2 - (table.getWidth() / 2), Game.V_HEIGHT / 2 - (table.getHeight() / 2));

		Label title = new Label("GAME OVER", skin);
		table.add(title);
		
		table.row();
		
		Label scoreLabel = new Label("YOUR SCORE : " + Integer.toString(ScoreManager.getScore()), skin);
		table.add(scoreLabel);
		
		table.row();
		
		/* KNYTTET TIL SCORE - IKKE SLETT
		Label saveLabel = new Label("WISH TO SAVE YOUR SCORE?", skin);
		table.add(saveLabel);
		
		table.row();
		
		TextButton yesButton = new TextButton("YES", skin);
		
		yesButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				game.setScreen(new SaveScoreScreen(game));
			}
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		table.add(yesButton);
		
		table.row();
		*/
		
		TextButton backToMainMenuButton = new TextButton("MAIN MENU", skin);
		backToMainMenuButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				game.setScreen(new MainMenuScreen(game));
			}
			
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		
		table.add(backToMainMenuButton);
	}

}