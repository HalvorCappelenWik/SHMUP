package com.javajunkies.model;

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
        _gameObjects = new ArrayList<>();

        _player = new Player(WIDTH/2, HEIGHT/2,100,100);
    }

    public void movePlayer(int x, int y){
        // Check if in bounds
        if (_player.getPositionX() + x >= 0 && _player.getPositionX() + x + _player.getWidth() <= WIDTH){
            _player.setPositionX(_player.getPositionX() + x);
        }
        if (_player.getPositionY() + y >= 0 && _player.getPositionY() + y + _player.getHeigtht() <= HEIGHT){
            _player.setPositionY(_player.getPositionY() + y);
        }
    }

    public List<GameObject> getGameObjects(){
        return this._gameObjects;
    }

    public GameObject getPlayer(){
        return this._player;
    }
}