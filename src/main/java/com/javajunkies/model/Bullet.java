package com.javajunkies.model;

import com.javajunkies.Vector2;

public class Bullet extends GameObject {

    private final int _speed = 500;

    /**
     * Creates a new GameObject of the type Bullet
     * @param position  The position of the bullet to spawn at
     */
    public Bullet(Vector2 position) {
        super(position, new Vector2(5, 10), "bullet");
    }

    @Override
    public void update(double deltaTime) {
        Vector2 delta = Vector2.up();
        delta.multiply(deltaTime * _speed);
        move(delta);

        if (this.getPosition().getY() < 0) {
            getScene().destroy(this);
        }
    }
    
}