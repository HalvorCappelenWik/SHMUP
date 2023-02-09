package com.javajunkies.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.javajunkies.App;
import com.javajunkies.model.GameObject;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GameView extends JPanel implements Viewable {

    private List<GameObject> gameObjects = new ArrayList<>();

    @Override
    public void paintComponent(Graphics canvas) {
        // super.paintComponent(canvas);
        if (gameObjects.size() > 0){
            for (GameObject obj : gameObjects) {
                canvas.fillRect(obj.positionX, obj.positionY, 100, 100);
            }
        }
    }

    @Override
    public void render(List<GameObject> gameObjects) {
        this.gameObjects = gameObjects;
        this.repaint();
    }

}
