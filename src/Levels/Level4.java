package Levels;

import Elements.*;
import city.cs.engine.Body;
import game.*;

import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.*;



    /**
     * Level 4
     */

    public class Level4 extends GameLevel {

        private static final int NUM_ORANGES = 25;
        private Image bg4;

        /**
         * Populate the world.
         */
        @Override
        public void populate(Game game) {
            super.populate(game);
            System.out.println(game.getBgN());
            this.bg4 = new ImageIcon("data/bg4.gif").getImage();
            // make the ground
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
            // walls
            // make some platforms


            Body Ramp1 = new RampNoPic(this,-15.32f,2.396f, 2.842f,-8.15f, -15.24f,0.15f);
            Ramp1.setPosition(new Vec2(2, 8.25f));

            Body floor1 = new Platform(this,12, 0.5f);
            floor1.setPosition(new Vec2(-6,-8));


            Body floor2 = new Platform(this,12, 0.5f);
            floor2.setPosition(new Vec2(-6,-4));
        }
        @Override
        public Vec2 startPosition() {
            return new Vec2(-10.4f, -3 );
        }
        @Override
        public Vec2 doorPosition() {
            return new Vec2(-10.4f, -10);
        }
        @Override
        public boolean isCompleted() {return getPlayer().getCoinCount() >= NUM_ORANGES;}
        @Override
        public Image getBackgroundImage() {
            if (bg4 == null) {
                bg4 = new ImageIcon("data/bg3.gif").getImage();
            }
            return this.bg4;
        }
        @Override
        public void setBackgroundImage() {
            this.bg4 = new ImageIcon("data/bg4.gif").getImage();
        }
        @Override
        public int GetLevelNumber() {
            return 4;
        }
        @Override
        public int EnemyHeight() {
            return 10;
        }
        @Override
        public Vec2 ChaserHeight() {
            return new Vec2(100, 12);
        }
        @Override
        public Vec2 CoinHeight() {
            return new Vec2(5.75f, 6.5f);
        }
        @Override
        public float GridSpacing() {
            return 5.75f;
        }
        @Override
        public float GridHeight() {
            return 90.5f;
        }
        @Override
        public Vec2 hballPos() {
            return new Vec2(300, 12);
        }
        @Override
        public float GridHeight2() {
            return 90.5f;
        }
        @Override
        public float Gs() {
            return 0.55f;
        }
        @Override
        public float Gs2() {
            return 7f;
        }
}