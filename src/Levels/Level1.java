package Levels;

import Sound.Sounds;
import city.cs.engine.*;
import game.*;
import Elements.*;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.*;

/**
 * Level 1 of the game
 */
public class Level1 extends GameLevel {

    private static final int NUM_ORANGES = 25;
    private Image bg1;
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        this.bg1 = new ImageIcon("data/bg1.gif").getImage();

        //GROUND
        Platform ground = new Platform(this, 12, 1);
        ground.setPosition(new Vec2(0, -12.5f));

        // MAKE CEILING
        Body ceiling = new Platform(this,12,  0.5f);
        ceiling.setPosition(new Vec2(0, 12.5f));
        // WALLS
        Body leftWall = new Platform(this, 0.5f,30 );
        leftWall.setPosition(new Vec2(-12.5f, 5.5f));

        Body rightWall = new Platform(this, 0.5f,30 );
        rightWall.setPosition(new Vec2(12.5f, 5.5f));

        Body Start = new Platform(this, 4,10);
        Start.setPosition(new Vec2(-8, -6));

        Body Holder = new Platform(this, 0.5f, 2);
        Holder.setPosition(new Vec2(-6, 9));

        Body RampL = new Ramp(this,-1.052f,2.448f, -2.468f,-0.468f, 2.448f,-0.46f);
        RampL.setPosition(new Vec2(-3,-12.25f));
        BodyImage image = new BodyImage("data/RAMP.png", 5);
        RampL.addImage(image);

        Body RampR = new Ramp(this, 1.052f,2.448f, -2.468f,-0.468f, 2.448f,-0.46f);
        RampR.setPosition(new Vec2(11, -12.25f));
        BodyImage image2 = new BodyImage("data/RAMP2.png", 5);
        RampR.addImage(image2);

        Sounds.getBackground().loop();
    }
    @Override
    public void stop(){

        Sounds.getBackground().stop();
        Sounds.getBackground2().stop();
        Sounds.getBackground3().stop();
    }


    @Override
    public Vec2 startPosition() {return new Vec2(-10, 10);}
    @Override
    public Vec2 doorPosition() {return new Vec2(11.5f, -9.6f);}
    @Override
    public boolean isCompleted() {return getPlayer().getCoinCount() >= NUM_ORANGES; }
    @Override
    public Image getBackgroundImage(){
        if (bg1 == null) {
            bg1 = new ImageIcon("data/gif").getImage();
        }
        return this.bg1;}
        @Override
        public void setBackgroundImage(){this.bg1 =new ImageIcon("data/bg1.gif").getImage(); }
    @Override
    public int GetLevelNumber() { return 1; }
    @Override
    public int EnemyHeight(){return 10;}
    @Override
    public Vec2 ChaserHeight(){return new Vec2(11,12);}
    @Override
    public Vec2 CoinHeight(){return new Vec2(-3.75f, 6.5f);};
    @Override
    public float GridSpacing(){return 20.75f;}
    @Override
    public float GridHeight(){return 6.5f;};
    @Override
    public float GridHeight2(){return 5.5f;};
    @Override
    public float Gs(){return 0.55f;}
    @Override
    public float Gs2(){return 7;}
    @Override
    public Vec2 hballPos(){return new Vec2(-5, 12);}
}

