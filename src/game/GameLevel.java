package game;

import Characters.Chaser;
import Characters.Enemy;
import Characters.HelperBalls;
import Characters.Semoji;
import Collectibles.Coins;
import Collectibles.Pickup;
import Door.Door;
import Door.DoorListener;
import Elements.BallGrid;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;

import java.util.*;

/**
 * A level of the game.
 */


public abstract class GameLevel extends World {
    private Semoji player;
    private Enemy player2;
    private Chaser player3;
    private BallGrid grid;
    private HelperBalls hball;
    private MyView view;
    public Semoji getPlayer() {
        return player;
    }
    public void setPlayer(Semoji p){this.player = p;}

    public int Level;
    public Enemy getPlayer2() {return player2; }

    public Chaser getPlayer3() {return player3; }



    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */

    public void populate(Game game) {


        player = new Semoji(this);
       player.setGravityScale(Gs2());

        player.setPosition(startPosition());



        player3 = new Chaser(this);
        player3.setPosition(ChaserHeight());
        player3.setGravityScale(0.4f);
        player3.addCollisionListener(new Pickup(getPlayer()));

        float xSpac = GridSpacing();
        float ySpac = GridHeight();
        float ySpac2 = GridHeight2();
        for (int j = 0; j < 4; j++) {
            xSpac = GridSpacing();
           ySpac = ySpac - 2.5f;
            for (int i = 0; i < 10; i++) {
                 grid = new BallGrid(this, 0.075f);


                Vec2 AcPos = new Vec2(xSpac,ySpac );

                grid.setPosition(AcPos);
                xSpac = xSpac - 2.5f;

            }
        }

        for (int j = 0; j < 4; j++) {
            xSpac = GridSpacing() + 1.25f;
            ySpac2 = ySpac2 - 2.5f;
            for (int i = 0; i < 10; i++) {
                grid = new BallGrid(this, 0.075f);
                if((j <1) && (i < 9)){
                player2 = new Enemy(this);
                player2.addCollisionListener(new Pickup(getPlayer()));
                player2.setGravityScale(Gs());
                player2.setPosition(new Vec2(xSpac - 3.50f,EnemyHeight()));}
                Vec2 AcPos = new Vec2(xSpac,ySpac2);
                grid.setPosition(AcPos);
                xSpac = xSpac - 2.5f;


            }
        }
for(int i = 0; i < 10; i++) {
    hball = new HelperBalls(this);
    hball.setPosition(hballPos());
}
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));


        for (int i = 0; i < 63; i++) {
            Body coins = new Coins(this);
            coins.setPosition(CoinHeight());
            coins.addCollisionListener(new Pickup(getPlayer()));



        }
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();

    public abstract Image getBackgroundImage();
    public abstract void setBackgroundImage();

    public abstract int GetLevelNumber();

    public abstract int EnemyHeight();

    public abstract Vec2 ChaserHeight();


    public abstract Vec2 CoinHeight();
    public abstract float GridHeight();
    public abstract float GridSpacing();
    public abstract Vec2 hballPos();
    public abstract float GridHeight2();

    public abstract float Gs();
    public abstract float Gs2();





}
