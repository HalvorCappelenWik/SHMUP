package com.javajunkies.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class GameModel {

    private final List<GameObject> _gameObjects;
    private final GameObject _player;
    private final int WIDTH;
    private final int HEIGHT;

    public GameModel(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        _gameObjects = initEnemies(5,1);

        _player = new Player(WIDTH/2, HEIGHT/2,10,10,100, Color.GREEN);
        _gameObjects.add(_player);
    }

    public void movePlayer(int x, int y){
        // Check if in bounds
        if (_player.getPositionX() + x >= 0 && _player.getPositionX() + x + _player.getWidth() <= WIDTH){
            _player.setPositionX(_player.getPositionX() + x);
        }
        if (_player.getPositionY() + y >= HEIGHT/2 && _player.getPositionY() + y + _player.getHeigtht() <= HEIGHT){
            _player.setPositionY(_player.getPositionY() + y);
        }
    }

    public List<GameObject> getGameObjects(){
        return new ArrayList<>(this._gameObjects);
    }

    public GameObject getPlayer(){
        return this._player;
    }
    
    private List<GameObject> initEnemies(int columns, int rows){
    	List<GameObject> enemies = new ArrayList<>(columns*rows);
    	int enemyWidth = (WIDTH-50) / columns;
    	int spacing = (WIDTH - (enemyWidth * columns)) / columns;
    	
    	for (int row = 0; row < rows; row++) {
    		for (int col = 0; col < columns; col++) {
    			int x = col * (enemyWidth + spacing) + spacing;
    			int y = row * (enemyWidth + spacing) + spacing;
    			enemies.add(new Enemy(x,y,enemyWidth, enemyWidth, Color.red));
    		}
    	}
    	
    	return enemies;
    }
}