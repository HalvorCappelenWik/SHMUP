package com.javajunkies.controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import com.javajunkies.Vector2;
import com.javajunkies.model.GameModel;

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

    
    private Vector2 getMoveInput()
    {
        if (leftPressed)  return new Vector2(-1, 0);
        if (upPressed)    return new Vector2(0, -1);
        if (downPressed)  return new Vector2(0, 1);
        if (rightPressed) return new Vector2(1, 0);
        return new Vector2(0, 0);
    }


    @Override
    public void run() {
        _model.update(1.0f / 60, getMoveInput());
        _view.repaint();
    }
}
