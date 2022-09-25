package Levels;

import Elements.*;
import Sound.Sounds;
import game.*;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.*;

/**
 * Level 2 of the game
 */
public class Level2 extends GameLevel {

    private static final int NUM_ORANGES = 25;
    private Image bg2;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        stop();
        super.populate(game);
        System.out.println(game.getBgN());
        this.bg2 = new ImageIcon("data/bg2.gif").getImage();

        Platform floor = new Platform(this,11,1);
        floor.setPosition(new Vec2(0, -8.5f));

        // walls
        Body RWall = new Platform(this, 0.5f,50.5f);
        RWall.setPosition(new Vec2(-11.5f, 1f));

        Body LWall = new Platform(this, 0.5f, 50.5f);
        LWall.setPosition(new Vec2(11.5f, 1f));


        Body RampL = new Ramp(this,-1.052f,2.448f, -2.468f,-0.468f, 2.448f,-0.46f);
        RampL.setPosition(new Vec2(-10,-7.65f));


        Sounds.getBackground2().loop();
        }



    @Override
    public void stop(){

        Sounds.getBackground().stop();
        Sounds.getBackground2().stop();
        Sounds.getBackground3().stop();
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(3, 30);
    }
    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -3.6f);
    }
    @Override
    public boolean isCompleted() {return getPlayer().getCoinCount() >= NUM_ORANGES; }
    @Override
    public Image getBackgroundImage(){
        if (bg2 == null) {
            bg2 = new ImageIcon("data/bg2.gif").getImage();
        }
        return this.bg2;}
    @Override
    public void setBackgroundImage(){this.bg2 =new ImageIcon("data/bg2.gif").getImage(); }
    @Override
    public int GetLevelNumber() {
        return 2;
    }
    @Override
    public int EnemyHeight(){return 40;}
    @Override
    public Vec2 ChaserHeight(){return new Vec2(100,12);}
    @Override
    public Vec2 CoinHeight(){return new Vec2(3, 10);}
    @Override
    public float GridSpacing(){return 10.75f;};
    @Override
    public float GridHeight(){return 8.5f;};
    @Override
    public float Gs(){return 0.10f;}
    @Override
    public float Gs2(){return 1.2f;}
    @Override
    public Vec2 hballPos(){return new Vec2(3, 29);}
    @Override
    public float GridHeight2(){return 7.5f;};
}

