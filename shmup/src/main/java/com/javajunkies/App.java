package com.javajunkies;
import java.awt.Dimension;

import javax.swing.*;

import com.javajunkies.controller.InputController;
import com.javajunkies.controller.KeyListenerInputController;
import com.javajunkies.controller.TestInputController;
import com.javajunkies.model.GameModel;
import com.javajunkies.view.GameView;
/**
 * Hello world!
 *
 */
public class App 
{
    public static final String WINDOW_TITLE = "JavaJunkies Shmup";
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;
    public static void main( String[] args )
    {
        GameView gameView = new GameView();
        KeyListenerInputController inputController = new KeyListenerInputController();
        GameModel gameModel = new GameModel(inputController, gameView);

        gameView.addKeyListener(inputController);

        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(gameView);

        frame.pack();
        frame.setVisible(true);

        gameView.setDoubleBuffered(false);
        gameView.requestFocus();
    }
}
