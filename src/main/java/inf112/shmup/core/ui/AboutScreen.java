package inf112.shmup.core.ui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;

public class AboutScreen extends UiScreen{

	/**
	 * Constructor for the AboutScreen class
	 * @param game The game being played
	 */
	public AboutScreen(Game game) {
		super(game);
	}

	@Override
	public void show() {
		Table table = new Table(skin);
		stage.addActor(table);
		
		//table.setDebug(true); // turn on all debug lines (table, cell, and widget)
		table.setPosition(Game.V_WIDTH / 2 - (table.getWidth() / 2), Game.V_HEIGHT / 2 - (table.getHeight() / 2));
		
		Label title = new Label("ABOUT", skin);
		title.setColor(MainMenuScreen.defaultColor);
		title.setFontScale(1.5f);
		table.add(title);
		
		table.row();
		
		Label emptyLabel = new Label("", skin);
		table.add(emptyLabel).height(50);
		
		table.row();
		
		Label controlKeysLabel = new Label("You control your spaceships with the arrow keys!", skin);
		controlKeysLabel.setColor(MainMenuScreen.defaultColor);
		table.add(controlKeysLabel);
		
		table.row();
		
		Image arrowKeysImage = new Image(new Texture(AssetManager.file("direction_keys.png")));
		table.add(arrowKeysImage).size(arrowKeysImage.getWidth()*3,arrowKeysImage.getHeight()*3);
		
		table.row();
		
		emptyLabel = new Label("", skin);
		table.add(emptyLabel).height(Game.V_HEIGHT/5);
		
		table.row();
		
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
		table.add(backButton).colspan(3);
	}

}