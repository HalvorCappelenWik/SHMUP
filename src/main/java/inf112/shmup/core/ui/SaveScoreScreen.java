package inf112.shmup.core.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.ScoreManager;
import inf112.shmup.core.utilities.ScoreboardManager;

public class SaveScoreScreen extends UiScreen{
	private boolean submitted;

	public SaveScoreScreen(final Game game) {
		super(game);
		
		try {
			ScoreboardManager.initialize();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		skin = new Skin(AssetManager.file("skin/sgx-ui.json"));
		
		submitted = false;
	}

	@Override
	public void show() {
		Table table = new Table(skin);
		stage.addActor(table);
		
		//table.setDebug(true); // turn on all debug lines (table, cell, and widget)
		table.setPosition(Game.V_WIDTH / 2 - (table.getWidth() / 2), Game.V_HEIGHT / 2 - (table.getHeight() / 2));
		
		Label title = new Label("SAVE YOUR SCORE", skin);
		table.add(title).colspan(2);
		
		table.row();
		
		Label usernameLabel = new Label("Username: ", skin);
		table.add(usernameLabel);
		
		TextField userNameField = new TextField("", skin);
		table.add(userNameField);
		
		table.row();
		
		Label messageLabel = new Label("", skin);
		
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
		
		TextButton submitButton = new TextButton("SUBMIT", skin);
		
		submitButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent e, float x, float y, int pointer, int button) {
				String username = userNameField.getText();
				if(username.length() < 3) {
					messageLabel.setText("Please give username of at least 3 characters");
					return;
				}
				
				if(submitted) {
					messageLabel.setText("You've already submitted! Head home!");
					return;
				}
			    try {
			    	ScoreboardManager.saveScoreForUser(username, ScoreManager.getScore());
			    	submitted = true;
			    	messageLabel.setText("Record saved successfully, head back to the menu");
			    	table.add(backToMainMenuButton);
			    } catch (Exception e1) {
			    	messageLabel.setText(e1.getMessage());
			    }
				
			}
			@Override
			public boolean touchDown (InputEvent e, float x, float y, int pointer, int button) {
				return true;
			}
		});
		table.add(submitButton).colspan(2);
		
		table.row();
		
		table.add(messageLabel).colspan(2);
		
		table.row();
	}
}
