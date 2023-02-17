package com.javajunkies.view;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

import com.javajunkies.model.GameObject;
import com.javajunkies.model.GameScene;

public class GameView extends JPanel{
    private final GameScene _scene;

    public GameView(GameScene scene){
        this._scene = scene;
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        for (GameObject gameObject : _scene.getGameObjects())
            paint(canvas, gameObject);
    }

    private void paint(Graphics canvas, GameObject gameObject) {
        if (gameObject.getSprite() == "player") {
            paintHitBox(canvas, gameObject, Color.green);

        } else if (gameObject.getSprite() == "enemy") {
            paintHitBox(canvas, gameObject, Color.red);

        } else if (gameObject.getSprite() == "bullet") {
            paintHitBox(canvas, gameObject, Color.orange);
        } else {
            paintHitBox(canvas, gameObject, getForeground());
        }
    }

    private void paintHitBox(Graphics canvas, GameObject gameObject, Color color) {
        canvas.setColor(color);
        canvas.fillRect(
            (int) gameObject.getPosition().getX(), 
            (int) gameObject.getPosition().getY(), 
            (int) gameObject.getHitBox().getX(), 
            (int) gameObject.getHitBox().getY());
    }
}