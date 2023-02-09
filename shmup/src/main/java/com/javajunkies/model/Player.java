package com.javajunkies.model;

import com.javajunkies.controller.InputController;

public class Player extends GameObject {
    
    private final InputController _input;

    public Player(int positionX, int positionY, InputController input) {
        super(positionX, positionY);
        _input = input;
    }

    @Override
    public void start() {

    }

    @Override 
    public void update() {
        int speed = 10;
        positionX += _input.getDirectionX() * speed;
    }
}
