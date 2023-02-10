package com.javajunkies.controller;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerInputController implements KeyListener, InputController{

    private int inputX = 0;
    private int inputY = 0;

    @Override
    public int getDirectionX() {
        return inputX;
    }

    @Override
    public int getDirectionY() {
        return inputY;
    }

    @Override
    public void keyPressed(KeyEvent evt) {
    	System.out.println(inputX + ", " + inputY);
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
}
