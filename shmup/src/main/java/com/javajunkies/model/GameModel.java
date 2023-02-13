package com.javajunkies.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.javajunkies.Vector2;

public class GameModel {

    private final List<GameObject> _gameObjects = new ArrayList<>();
    private final Player _player;
    private final int WIDTH;
    private final int HEIGHT;

    public GameModel(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        _player = new Player(new Vector2(WIDTH/2, HEIGHT/2), new Vector2(10, 10) ,100, Color.GREEN);
        addGameObject(_player);
        spawnEnemies(5, 1);
    }

    public void update(float deltaTime, Vector2 input) {
        _player.setInput(input);

        for (GameObject gameObject : _gameObjects)
            gameObject.update(deltaTime);

        containPlayer();
    }

    private void containPlayer()
    {
        Vector2 position = _player.getPosition();
        Vector2 size = _player.getSize();

        if (position.getX() < 0) position.setX(0);
        if (position.getX() + size.getX() > WIDTH) position.setX(WIDTH - size.getX());
        
        if (position.getY() < HEIGHT/2) position.setY(HEIGHT/2);
        if (position.getY() + size.getY() > HEIGHT) position.setY(HEIGHT - size.getY());

        _player.setPosition(position);
    }

    public List<GameObject> getGameObjects(){
        return new ArrayList<>(this._gameObjects);
    }

    public void addGameObject(GameObject gameObject) {
        _gameObjects.add(gameObject);
    }

    private void spawnEnemies(int columns, int rows){
    	int enemyWidth = (WIDTH-50) / columns;
    	int spacing = (WIDTH - (enemyWidth * columns)) / columns;
    	
    	for (int row = 0; row < rows; row++) {
    		for (int col = 0; col < columns; col++) {
    			int x = col * (enemyWidth + spacing) + spacing;
    			int y = row * (enemyWidth + spacing) + spacing;
    			addGameObject(new Enemy(x,y,enemyWidth, enemyWidth, Color.red));
    		}
    	}
    }
}