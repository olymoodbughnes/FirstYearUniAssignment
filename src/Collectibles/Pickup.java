package Collectibles;

import Characters.Chaser;
import Characters.Enemy;
import Characters.HelperBalls;
import Characters.Semoji;
import Collectibles.Coins;
import Elements.Platform;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.util.EnumMap;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Semoji emoji;
    public Pickup(Semoji emoji) {
        this.emoji = emoji;
    }


    @Override
    public void collide(CollisionEvent e) {

        if ((e.getOtherBody() instanceof Semoji && e.getReportingBody() instanceof Enemy) || (e.getOtherBody() instanceof Semoji && e.getReportingBody() instanceof Coins) || (e.getOtherBody() instanceof Semoji && e.getReportingBody() instanceof Chaser)) {
            e.getReportingBody().destroy();

            if (e.getReportingBody() instanceof Coins){
                emoji.incrementCoinCount();
            }
                if (emoji.getCoinCount() == 61){




                }
                else if (e.getReportingBody()instanceof Enemy){
                    emoji.decrementHealthCount();


            } else if(e.getReportingBody()instanceof Chaser){
                    emoji.decrementHealthCount2();

                }


        }
        if (emoji.getHealthCount() < 0){
            System.out.println("YOU LOSE!!");
            System.exit(27);
            }
        if(e.getOtherBody() instanceof Enemy && e.getReportingBody() instanceof HelperBalls){
            if(e.getReportingBody()instanceof Enemy) {
                e.getReportingBody().destroy();
            }

        }


        }
        }

    

