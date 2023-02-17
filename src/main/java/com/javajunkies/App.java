package com.javajunkies;
import java.awt.Dimension;

import javax.swing.*;

import com.javajunkies.controller.KeyListenerInputController;
import com.javajunkies.model.GameModel;
import com.javajunkies.view.GameView;

public class App 
{
    public static final String WINDOW_TITLE = "JavaJunkies Shmup";
    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public static void main( String[] args )
    {
        // Initialize game logic
        GameModel model = new GameModel(WIDTH, HEIGHT);
        GameView view = new GameView(model);
        KeyListenerInputController controller = new KeyListenerInputController(model, view);

        // Initialize UI
        view.addKeyListener(controller);

        JFrame frame = new JFrame(WINDOW_TITLE);
        frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setContentPane(view);

        frame.pack();
        frame.setVisible(true);

        view.setDoubleBuffered(false);
        view.requestFocus();
    }
}