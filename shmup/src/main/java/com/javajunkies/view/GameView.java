package com.javajunkies.view;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import com.javajunkies.model.GameModel;
import com.javajunkies.model.GameObject;

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
            	canvas.setColor(obj.getColor());
                canvas.fillRect(
                    (int) obj.getPosition().getX(), 
                    (int) obj.getPosition().getY(), 
                    (int) obj.getSize().getX(), 
                    (int) obj.getSize().getY());
            }
        }
    }

}
