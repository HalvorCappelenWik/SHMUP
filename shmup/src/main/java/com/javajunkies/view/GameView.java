package com.javajunkies.view;

import javax.swing.JComponent;
import javax.swing.JPanel;

import com.javajunkies.App;
import com.javajunkies.model.GameModel;
import com.javajunkies.model.GameObject;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class GameView extends JPanel{
    private GameModel _model;

    public GameView(GameModel model){
        this._model = model;
    }

    @Override
    public void paint(Graphics canvas) {
        super.paint(canvas);
        List<GameObject> gameObjects = _model.getGameObjects();
        if (gameObjects.size() > 0){
            for (GameObject obj : gameObjects) {
                canvas.fillRect(obj.getPositionX(), obj.getPositionY(), obj.getWidth(), obj.getHeigtht());
            }
        }
    }

}
