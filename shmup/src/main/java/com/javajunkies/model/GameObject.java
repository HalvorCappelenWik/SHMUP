package com.javajunkies.model;

import com.javajunkies.controller.InputController;

public abstract class GameObject {
    
    public int positionX;
    public int positionY;

    public GameObject(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public abstract void start();

    public abstract void update();

}
