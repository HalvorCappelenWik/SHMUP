package com.javajunkies.model;

import java.util.ArrayList;
import java.util.List;

import com.javajunkies.Vector2;

/**
 * Manages the state of the game.
 */
public class GameModel implements GameScene {

    private final List<GameObject> _gameObjects = new ArrayList<>();
    private final Player _player;
    private final int WIDTH;
    private final int HEIGHT;

    /**
     * Creates a new game model.
     * 
     * @param WIDTH Width of the screen.
     * @param HEIGHT Height of the screen.
     */
    public GameModel(int WIDTH, int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        _player = new Player(new Vector2(WIDTH/2, HEIGHT/2));
        spawn(_player);
        spawnEnemies(5, 1);
    }

    /**
     * Compute game state for next frame.
     * @param deltaTime Time in seconds since last frame.
     * @param input Current user movement input.
     */
    public void update(double deltaTime, Vector2 input) {
        _player.setInput(input);

        for (GameObject gameObject : new ArrayList<>(_gameObjects))
            gameObject.update(deltaTime);

        containPlayer();
        testMethod();
    }

    private void containPlayer()
    {
        Vector2 position = _player.getPosition();
        Vector2 size = _player.getHitBox();

        if (position.getX() < 0) position.setX(0);
        if (position.getX() + size.getX() > WIDTH) position.setX(WIDTH - size.getX());

        if (position.getY() < HEIGHT/2) position.setY(HEIGHT/2);
        if (position.getY() + size.getY() > HEIGHT) position.setY(HEIGHT - size.getY());

        _player.setPosition(position);
    }

    @Override
    public Iterable<GameObject> getGameObjects(){
        return new ArrayList<>(this._gameObjects);
    }

    @Override
    public void spawn(GameObject gameObject) {
        if (_gameObjects.contains(gameObject)) return;
        _gameObjects.add(gameObject);
        gameObject.setScene(this);
    }

    @Override
    public void destroy(GameObject gameObject) {
        _gameObjects.remove(gameObject);
        gameObject.setScene(null);
    }

    private void spawnEnemies(int columns, int rows){
    	int enemyWidth = (WIDTH-50) / columns;
    	int spacing = (WIDTH - (enemyWidth * columns)) / columns;
    	
    	for (int row = 0; row < rows; row++) {
    		for (int col = 0; col < columns; col++) {
    			int x = col * (enemyWidth + spacing) + spacing;
    			int y = row * (enemyWidth + spacing) + spacing;
    			spawn(new Enemy(new Vector2(x,y),new Vector2(enemyWidth, enemyWidth)));
    		}
    	}
    }

    private ArrayList<GameObject> getBullets() {
        ArrayList<GameObject> bullets = new ArrayList<>();
        for (GameObject gameObject : _gameObjects) {
            if (gameObject.getSprite().equals("bullet")) {
                bullets.add(gameObject);
            }
        }
        return bullets;
    }

    private ArrayList<GameObject> getEnemies() {
        ArrayList<GameObject> enemies = new ArrayList<>();
        for (GameObject gameObject : _gameObjects) {
            if (gameObject.getSprite().equals("enemy")) {
                enemies.add(gameObject);
            }
        }
        return enemies;
    }

    private void testMethod() {
        for (GameObject bullet : getBullets()) {
            for (GameObject enemy : getEnemies()) {
                if (bullet.hasCollidedWith(enemy)) {
                    destroy(bullet);
                    destroy(enemy);
                }
            }
        }
    }

}