package com.javajunkies.controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import com.javajunkies.model.GameModel;
import com.javajunkies.model.GameObject;

public class KeyListenerInputController extends TimerTask implements KeyListener{

    private int inputX = 0;
    private int inputY = 0;
    private GameModel _model;
    private final Timer _timer;
    private final JPanel _view;

    public KeyListenerInputController(GameModel model, JPanel view){
        this._model = model;
        this._view = view;
        _timer = new Timer();
        _timer.scheduleAtFixedRate(this, 0, 1000 / 60);
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        handleKey(evt.getKeyCode(), 1);
    }


    @Override
    public void keyReleased(KeyEvent evt) {
        handleKey(evt.getKeyCode(), -1);
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // Ignored
    }

    private void handleKey(int keyCode, int multiplier)
    {
        switch (keyCode)
        {
            case KeyEvent.VK_LEFT:
                inputX -= multiplier;
                break;
            case KeyEvent.VK_RIGHT:
                inputX += multiplier;
                break;
            case KeyEvent.VK_UP:
                inputY -= multiplier;
                break;
            case KeyEvent.VK_DOWN:
                inputY += multiplier;
                break;
        }

        inputX = clamp11(inputX);
        inputY = clamp11(inputY);
    }
    
    private static int clamp11(int value) {
        if (value > 1) return 1;
        if (value < -1) return -1;
        return value;
    }

    @Override
    public void run() {
        // Move player in the model
        _model.movePlayer(inputX, inputY);
        List<GameObject> objects = _model.getGameObjects();
        objects.add(_model.getPlayer());
        _view.repaint();
    }
}
