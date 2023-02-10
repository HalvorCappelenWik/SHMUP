package com.javajunkies.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import com.javajunkies.controller.InputController;
import com.javajunkies.view.Viewable;

public class GameModel extends TimerTask  {
    private final InputController _input;
    private final Viewable _view;
    private final List<GameObject> _gameObjects;
    private final Timer _timer;

    public GameModel(InputController input, Viewable view) {
        _input = input;
        _view = view;
        _gameObjects = new ArrayList<>();
        _timer = new Timer();
        _timer.scheduleAtFixedRate(this, 0, 1000 / 30);

        _gameObjects.add(new Player(100,100,100,100));
    }

    @Override
    public void run() {
        // Spill logikk
        for (GameObject gameObject : _gameObjects) {
        	//System.out.println(_input.getDirectionX() + _input.getDirectionY());
            gameObject.move(_input.getDirectionX(), _input.getDirectionY());
        }

        // Tegne
        _view.render(_gameObjects);
    }
}