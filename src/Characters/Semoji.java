package Characters;

import city.cs.engine.*;

/**
 * Simple character
 */
public class Semoji extends Walker {
    private static final Shape shape = new PolygonShape(-0.40f,0.216f, 0.08f,-1.06f,0.719f,0.244f
    );

    private static final BodyImage image =
        new BodyImage("data/annoyingemoji.gif", 3);


    private int coinCount;
    private int healthPoints;
    private int  changeD = 1;




    public void setChangeD(int changeD) {
        this.changeD = changeD;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Semoji(World world) {
        super(world, shape);
        addImage(image);
        coinCount = 0;
        healthPoints = 10;
    }

    public int getCoinCount() {
        return coinCount;
    }

    public void incrementCoinCount() {
        coinCount++;

    }

    public void setCoinCount(int c){coinCount = c;

    }
    public int getHealthCount() {
        return healthPoints;
    }

    public void decrementHealthCount() {
        healthPoints = healthPoints-5;
        System.out.println("OUCH  lives remaining =  " + healthPoints);
    }
    public void decrementHealthCount2() {
        healthPoints = healthPoints - 11 ;
        System.out.println("OUCH  lives remaining =  " + healthPoints);
    }
}
