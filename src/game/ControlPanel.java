package game;

import SaveFeature.LoadSavedState;
import SaveFeature.SaveState;
import game.Game;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class ControlPanel extends JPanel {
    private JPanel ControlPanel;
    private Game game;


    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton saveButton;
    private JButton loadButton;
    private JButton resetButton;
    private JButton skipLevelButton;
    private JButton goBackButton;


    public JPanel getMenu(){return ControlPanel;}

    public ControlPanel(Game game) {
        this.game = game;
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.quit();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.pause();
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.resume();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LoadSavedState sr = new LoadSavedState("data/scores.txt", game);
                try {
                    GameLevel loadedGame = sr.LoadSavedState();
                    game.goToLevel(loadedGame);
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.saveGame();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.goRestart();
            }
        });
        skipLevelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.SkipLevel();
            }
        });

        goBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.BackLevel();
            }
        });


    }

}

