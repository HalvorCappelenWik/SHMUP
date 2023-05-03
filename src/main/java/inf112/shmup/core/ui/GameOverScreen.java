package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.ScoreManager;
import inf112.shmup.core.utilities.ScoreboardManager;

public class GameOverScreen extends UiScreen{
	
	public GameOverScreen(final Game game) {
		super(game);
	}

	private void addLabel(String text, float y) {
		Label label = new Label(text, new LabelStyle(game.font, Color.BLACK));
		label.setX(Gdx.graphics.getWidth() * 0.5f - label.getWidth() * 0.5f);
		label.setY(y);
		stage.addActor(label);
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
	}
}
