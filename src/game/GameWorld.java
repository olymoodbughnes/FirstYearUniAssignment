package game;

import Characters.Enemy;
import Characters.Semoji;
import Collectibles.Coins;
import Collectibles.Pickup;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.util.Random;

/**
 *
 * @author greg
 */

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Semoji semoji;
    private Enemy enemy;

Random rand = new Random();

    public GameWorld() {
        super();


        // make the ground

                Shape groundShape = new BoxShape(12, 0.5f);
                Body ground = new StaticBody(this, groundShape);
                ground.setPosition(new Vec2(0, -12.5f));



        // MAKE CEILING
        Shape ceilingShape = new BoxShape(12, 0.5f);
        Body ceiling = new StaticBody(this, ceilingShape);
        ceiling.setPosition(new Vec2(0, 12.5f));
        // walls
        Shape leftWallShape = new BoxShape(0.5f, 30, new Vec2(-12.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 30, new Vec2(12.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);

       /* Shape obstacleShape = new BoxShape(5.5f, 0.5f);
        Body obstacle = new DynamicBody(this, obstacleShape);
        obstacle.setPosition(new Vec2(-3, 5.5f));*/
        // make platforms
       Shape boxShape = new BoxShape(4, 10);
        Body platform1 = new StaticBody(this, boxShape);
        platform1.setPosition(new Vec2(-8, -6));


        Shape boxRetainer = new BoxShape(0.5f,2);
        Body platform2 = new StaticBody(this, boxRetainer);
        platform2.setPosition(new Vec2(-6, 9));



        Shape platform69Shape  = new PolygonShape(-1.052f,2.448f, -2.468f,-0.468f, 2.448f,-0.46f/*-2.23f,-2.078f, 2.094f,2.134f, 2.108f,-2.068f*/);
        Body platform69 = new StaticBody(this,platform69Shape);
        platform69.setPosition(new Vec2(-3,-12.25f));
       BodyImage image = new BodyImage("C:/Users/yairo/Pictures/Camera Roll/RAMP.png", 5);
        platform69.addImage(image);
        // add another platform here

        Shape platform3Shape = new PolygonShape(1.052f,2.448f, -2.468f,-0.468f, 2.448f,-0.46f/*-2.166f,2.016f, -2.392f,-2.258f, 2.284f,-2.262f, 2.444f,2.02f, 2.01f,2.064f*/);
        Body platform3 = new StaticBody(this, platform3Shape);
        platform3.setPosition(new Vec2(11, -12.25f));
        BodyImage image2 = new BodyImage("C:/Users/yairo/Pictures/Camera Roll/RAMP2.png", 5);
        platform3.addImage(image2);


        for (int i = 0;i < 10; i = i + 1) {
            for (int j = 0; j< 1; j = j + 1) {


                Vec2 a = new Vec2(-5, 12);
                Shape balls = new CircleShape(0.60f);
                Body BALLS = new DynamicBody(this, balls);
                BALLS.setPosition(a);
            }


        }
        
        semoji = new Semoji(this);
        semoji.setPosition(new Vec2(-8, 9));
        semoji.setGravityScale(7);



        for (int i = 0;i < 10; i = i + 1) {
            enemy = new Enemy(this);
            /*X*/
            double nuum = rand.nextInt((12 - 1) + 1) + 1;
            float numberA = (float) nuum;

            /*Y*/
            double nuum2 = rand.nextInt((1 - 1) + 1) + 1;
            float numberB = (float) nuum2;
            enemy.setPosition(new Vec2(numberA, numberB));
            enemy.setFillColor(Color.red);
            enemy.addCollisionListener(new Pickup(semoji));
            enemy.setGravityScale(0.01f);



        }

        for (int h = 0; h < 4; ++h) {
            }
for (int i = 0; i < 61; i++) {
            Body coins = new Coins(this);
            coins.setPosition(new Vec2(-3.75f, 6.5f));
           coins.addCollisionListener(new Pickup(semoji));



        }
    }
    
    public Semoji getPlayer() {
        return semoji;
    }
}
