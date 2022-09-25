package game;
/**Importing important assets from packages**/
/**Importing player character**/
import Characters.Semoji;
/**Importing all stages from the levels package**/
import Levels.*;
/**Importing assets from the custom city engine**/
import SaveFeature.SaveState;
import city.cs.engine.*;
import java.awt.*;
import java.io.IOException;
import javax.swing.*;

/**
 * @author      first name, last name, email
 * @version     current version number of program
 * @since       the version of the package this class was first added to
 */
public class Game {

    /**
     * The World in which the bodies move and interact.
     */
    private GameLevel world;

    /**
     * Here variables that correlate to graphical display of the world, the level in the player may be in and other important variables are declared.
     */
    private UserView view;
    private int level;
    private String a = "data/bg1.gif";
    private Controller controller;



    /**
     * The game is launched through the use of this code below.
     */
    public Game() {


        /**
         *World is made.
         */
        level = 1;
        world = new Level1();
        world.populate(this);
        view = new MyView(world, 500, 500);


        /**
         * Here a way of viewing the created world is declared.
         */
        final JFrame frame = new JFrame("Event handling");

        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMenu(), BorderLayout.WEST);

        /**
         *  quit the application when the game window is closed
         */

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        /**
         *display the world in the window
         *
         */
        frame.add(view);
        /**
         *
         don't let the game window be resized
         */
        frame.setResizable(false);
        /**
         * size the game window to fit the world view
         */
        frame.pack();
        /**
         *
          make the window visible
         */
        frame.setVisible(true);
        /**
         * get keyboard focus
          */
        frame.requestFocus();
        /**
         * give keyboard focus to the frame whenever the mouse enters the view
         *
         */
        view.addMouseListener(new GiveFocus(frame));
        controller = new Controller(world.getPlayer(), world, this);
        frame.addKeyListener(controller);

        /**
         * the world is displayed
         */
        world.start();

    }

    /**
     *Method to stop the world from running
     */

    public void pause() {
        world.stop();
    }

    /**
     * Method for resuming after the game has been paused
     */

    public void resume() {
        world.start();
    }

    /**
     * Method that stops the program once called
     */
    public void quit() {
        System.exit(0);
    }


    /**
     * Method that saves the game into a file named scores once it is called
     */
    public void saveGame() {

        SaveState sw = new SaveState("data/scores.txt");
        try {
            sw.writeSaveState(controller.getCurrentLevel());
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @return This method return the player currently in the game once called.
     */
    public Semoji getPlayer() {
        return world.getPlayer();
    }

    /**
     * This method returns a method call once this one has been called.
     */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /**
     * This method restarts the level the player is currently at.
     */
    public void goRestart() {
            world.stop();
        if (level == 1) {
            world = new Level1();
            world.populate(this);
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(0);
            world.getPlayer().setHealthPoints(getPlayer().getHealthCount());
            view.setWorld(world);
            world.start();
        } else if (level == 2) {
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(0);
            world.getPlayer().setHealthPoints(getPlayer().getHealthCount());
            view.setWorld(world);
            world.start();
        } else if (level == 3) {
            world = new Level3();
            world.populate(this);
             controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(0);
             world.getPlayer().setHealthPoints(getPlayer().getHealthCount());
            view.setWorld(world);
            world.start();
        } else if (level == 4) {
            world = new Level4();
            world.populate(this);
            controller.setBody(world.getPlayer());
            world.getPlayer().setCoinCount(0);
            world.getPlayer().setHealthPoints(getPlayer().getHealthCount());
            view.setWorld(world);
            world.start();
        }
    }
    /**
     * Advance to the next level of the game.
     */
    public void goToLevel(GameLevel current){
            world.stop();
            level = current.GetLevelNumber();
            world = current;
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            world.start();
    }

    /**
     * These two methods are used by the buttons on the GUI in order to skip and go back a level.
     */
    public void SkipLevel(){goNextLevel();}
    public void BackLevel(){goBackLevel();}

    /**
     * This method is similar to the first "game" method except it has some changes so that it can go between levels once certain conditions are met.
     */
    public void goNextLevel() {
        world.stop();
        if (level == 4) {
            System.exit(0);
        } else if (level == 1) {
            level++;
            System.out.println(getBgN());
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            view.setWorld(world);
            world.start();
        }else if (level == 2){
            level++;
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            view.setWorld(world);
            world.start();
        }else if (level == 3){
            level++;
            world = new Level4();
            world.populate(this);
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            view.setWorld(world);
            world.start();
        }
    }

    /**
     * This method does exactly the same as the last method except it's purpose is to do everything backwards thus letting the player go back a level.
     */
    public void goBackLevel() {
        world.stop();
        if (level == 0) {
            System.exit(0);
        } else if (level == 1) {
            level--;
            System.out.println(getBgN());
            world.populate(this);
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            view.setWorld(world);
            world.start();
        }else if (level == 2){
            level--;
            world = new Level1();
            world.populate(this);
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            view.setZoom(10);
            view.setWorld(world);
            world.start();
        }else if (level == 3){
            level--;
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            view.setWorld(world);
            world.start();

        }else if (level == 4){

            level--;
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            controller.setWorld(world);
            view.setWorld(world);
            world.start();
        }
    }

    /**
     * This is the main method and it calls the first "game" method.
     */
    public static void main(String[] args) throws IOException {
        new Game();

    }

    /**
     *
     * @return the value that represents the background image/gif.
     */
    public String getBgN() {
        return a;
    }

    /**
     *
     * @return the value that represents each level.
     */
    public int getLevel() {
        return level;
    }




}

