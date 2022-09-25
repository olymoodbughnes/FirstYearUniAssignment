package Levels;

import Elements.*;
import Sound.Sounds;
import city.cs.engine.*;
import game.*;

import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.*;

/**
 * Level 3
 */
public class Level3 extends GameLevel {

    private static final int NUM_ORANGES = 25;
    private Image bg3;
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        System.out.println(game.getBgN());
        this.bg3 = new ImageIcon("data/bg3.gif").getImage();
        // make the ground
        Platform Ground = new Platform(this, 11, 1);
        Ground.setPosition(new Vec2(6, -11.5f));
        // walls
        // make some platforms
        Body Ramp1 = new RampNoPic(this,-6.246f,6.196f, 10.29f,-6.18f, -6.25f,-6.18f);
        Ramp1.setPosition(new Vec2(3,-5.25f));

        Body Ramp2 = new RampNoPic(this,-4.476f,-4.116f, 12.452f,5.02f, 7.45f,-4.06f);
        Ramp2.setPosition(new Vec2(5, 8.25f));

        Body Ramp3 = new RampNoPic(this, 1.052f,2.448f, -2.468f,-0.468f, 2.448f,2.46f);
        Ramp3.setPosition(new Vec2(11, -11.50f));
        Sounds.getBackground3().loop();
    }
    @Override
    public void stop(){

        Sounds.getBackground().stop();
        Sounds.getBackground2().stop();
        Sounds.getBackground3().stop();
    }
    @Override
    public Vec2 startPosition() {return new Vec2(8, -5);}
    @Override
    public Vec2 doorPosition() {return new Vec2(-10.4f, -13.6f);}
    @Override
    public boolean isCompleted() {return getPlayer().getCoinCount() >= NUM_ORANGES; }
    @Override
    public Image getBackgroundImage(){

        if (bg3 == null) {
            bg3 = new ImageIcon("data/bg3.gif").getImage();
        }return this.bg3;}
    @Override
    public void setBackgroundImage(){this.bg3 =new ImageIcon("data/bg3.gif").getImage();}
    @Override
    public int GetLevelNumber() {return 3;}
    @Override
    public int EnemyHeight(){return -100;}
    @Override
    public Vec2 ChaserHeight(){return new Vec2(100,12);}
    @Override
    public Vec2 CoinHeight(){return new Vec2(5.75f, 6.5f);}
    @Override
    public float GridSpacing(){return -300.75f;};
    @Override
    public float GridHeight(){return 6.5f;};
    @Override
    public Vec2 hballPos(){return new Vec2(300, 12);}
    @Override
    public float GridHeight2(){return 6.5f;};
    @Override
    public float Gs(){return 0.75f;}
    @Override
    public float Gs2(){return 7f;}}

