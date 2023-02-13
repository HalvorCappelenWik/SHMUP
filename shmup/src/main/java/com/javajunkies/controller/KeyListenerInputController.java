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

    private boolean leftPressed = false;
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean rightPressed = false;
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
        int keyCode = evt.getKeyCode();
        switch (keyCode)
        {
            case KeyEvent.VK_LEFT:
                leftPressed = true;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = true;
                break;
            case KeyEvent.VK_UP:
                upPressed = true;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = true;
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent evt) {
    	int keyCode = evt.getKeyCode();
        switch (keyCode)
        {
            case KeyEvent.VK_LEFT:
                leftPressed = false;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = false;
                break;
            case KeyEvent.VK_UP:
                upPressed = false;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = false;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // Ignored
    }

    
    private void moveIfPressed()
    {
        if (leftPressed)  _model.movePlayer(-1, 0);
        if (upPressed)    _model.movePlayer(0, -1);
        if (downPressed)  _model.movePlayer(0, 1);
        if (rightPressed) _model.movePlayer(1, 0);
        
    }


    @Override
    public void run() {
    	moveIfPressed();
        List<GameObject> objects = _model.getGameObjects();
        objects.add(_model.getPlayer());
        _view.repaint();
    }
}
