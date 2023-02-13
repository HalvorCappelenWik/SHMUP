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
    private final GameModel _model;
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
        handleKeyEvent(evt, true);
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        handleKeyEvent(evt, false);
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        // Ignored
    }

    private void handleKeyEvent(KeyEvent evt, boolean isPressed) {
        int keyCode = evt.getKeyCode();
        switch (keyCode)
        {
            case KeyEvent.VK_LEFT:
                leftPressed = isPressed;
                break;
            case KeyEvent.VK_RIGHT:
                rightPressed = isPressed;
                break;
            case KeyEvent.VK_UP:
                upPressed = isPressed;
                break;
            case KeyEvent.VK_DOWN:
                downPressed = isPressed;
                break;
        }
    }
    
    private Vector2 getMoveInput()
    {
        Vector2 input = Vector2.zero();
        if (leftPressed)  input.add(Vector2.left());
        if (upPressed)    input.add(Vector2.up());
        if (downPressed)  input.add(Vector2.down());
        if (rightPressed) input.add(Vector2.right());
        return input;
    }


    @Override
    public void run() {
        _model.update(1.0f / 60, getMoveInput());
        _view.repaint();
    }
}
