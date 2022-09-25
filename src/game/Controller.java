package game;

import SaveFeature.LoadSavedState;
import SaveFeature.SaveState;
import city.cs.engine.*;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import game.*;
import org.jbox2d.common.Vec2;

//CONTROLS FOR WALKER ARE SET UP BY EXTENDING KEYADAPTER
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 9;
    
    private Walker body;


    private GameLevel currentLevel;
    private Game game;

    public Controller(Walker body, GameLevel level, Game game) {
        this.body = body;
        currentLevel = level;
        this.game = game;
    }
    //BOOST FEATURE INITIALISED AT 0
    public int boost = 0;


    /**
     * Handle key press events for walking and jumping.
     * @param e description of t q he key event
     */

    @Override

    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_SPACE) {
           //TOGGLE BOOST FEATURE BY SETTING BOOST TO 1
            boost = 1;



        }
        /*BOOST FEATURE IMPLEMENTED{ONLY WORKS IF TOGGLED},
        ONCE USED IT WILL BE RESET SO THAT THE PLAYER WON'T PERPETUALLY BOOST*/
        if (code == KeyEvent.VK_A && boost == 1){
            boost  = 0;
            body.startWalking(-WALKING_SPEED*2);// walk left with boost(2x speed)

        }
            else if (code == KeyEvent.VK_A) {
            boost = 0;
            body.startWalking(-WALKING_SPEED);// A = walk left

        }
        if (code == KeyEvent.VK_D && boost == 1){
            boost = 0;
            body.startWalking(WALKING_SPEED*2);// walk right with boost(2x speed)
        }
        else if (code == KeyEvent.VK_D) {
            boost = 0;
            body.startWalking(WALKING_SPEED);// 2 = walk right
        }
        else if (code == KeyEvent.VK_S) {
            //TOGGLE BOOST FEATURE BY SETTING BOOST TO 1
            SaveState sw = new SaveState("data/scores.txt");
            try {
                sw.writeSaveState(currentLevel);
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }
        else if (code == KeyEvent.VK_L) {
            //TOGGLE BOOST FEATURE BY SETTING BOOST TO 1
            LoadSavedState sw = new LoadSavedState("data/scores.txt", game);
            try {
                GameLevel loadedSave = sw.LoadSavedState();
                game.goToLevel(loadedSave);
            } catch (IOException ex) {
                ex.printStackTrace();
            }


        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    //LETS THE WALKER CONTROLLED BY THE USER STOP WALKING AFTER A CERTAIN AMOUNT OF TIME
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        }
    }
    public void setBody(Walker body) {
        this.body = body;
    }

    public void setWorld(GameLevel level){this.currentLevel = level; }

    public GameLevel getCurrentLevel() {
        return currentLevel;
    }
}
