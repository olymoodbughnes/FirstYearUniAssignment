package SaveFeature;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Characters.*;
import Collectibles.*;
import Door.*;
import Elements.*;
import Levels.*;
import city.cs.engine.*;
import game.*;
import org.jbox2d.common.Vec2;


/**
 * @author      first name, last name, email
 * @version     current version number of program
 * @since       the version of the package this class was first added to
 */


public class LoadSavedState {
    /**
     * Below are instances where variables of type String and Game are created.
     */

    private String fileName;
    private Game game;

    /**
     * Start of the definition of the Loading feature
     */
    public LoadSavedState(String fileName, Game g) {
        this.fileName = fileName;
        game = g;

    }

    public GameLevel LoadSavedState() throws IOException {

        FileReader fr = null;
        BufferedReader reader = null;


        try {

            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            /**
             * Defines an integer that will guide the program to associate the right attriutes to the right levels (1 - 4).
             */
            int levelNumber = Integer.parseInt(line);

            GameLevel level = null;
            /**
             * The levels are attributed to the right integer value representing each level.
             */
            if(levelNumber == 1)
            {
                level = new Level1();
                level.setBackgroundImage();
            }
            else if (levelNumber == 2)
            {
                level = new Level2();
                level.setBackgroundImage();

            }
            else if (levelNumber == 3){
                level = new Level3();
                level.setBackgroundImage();

            }
            else if (levelNumber == 4){
                level = new Level4();
                level.setBackgroundImage();

            }
            /**
             * Basic information is read from the saved text file, each chunk of information is separated by a comma.
             */
            while ((line = reader.readLine()) != null)
            {
                String[] tokens = line.split(",");
                String className = tokens[0];
                Float xAxisPlayer = Float.parseFloat(tokens[1]);
                Float yAxisPlayer = Float.parseFloat(tokens[2]);

                Vec2 PlayerLoc = new Vec2(xAxisPlayer, yAxisPlayer);

                /**
                 * Beggining of conditional statements that filter each class type that will be loaded into the game.
                 * This also attaches the right attributes to each class.
                 */
                if (className.equals("Semoji"))
                {
                    Float Gravity = Float.parseFloat(tokens[3]);
                    Float Count = Float.parseFloat(tokens[4]);
                    Float HCount = Float.parseFloat(tokens[5]);
                    int a = Count.intValue();
                    int c = HCount.intValue();
                    Semoji b = new Semoji(level);
                    b.setGravityScale(Gravity);
                    b.setPosition(PlayerLoc);
                    b.setCoinCount(a);
                    b.setHealthPoints(c);


                    level.setPlayer(b);

                }
                if (className.equals("Enemy"))
                {
                    Float Gravity = Float.parseFloat(tokens[3]);
                    Enemy b = new Enemy(level);
                    b.setPosition(PlayerLoc);
                    b.setGravityScale(Gravity);
                    b.addCollisionListener(new Pickup(level.getPlayer()));




                }

                if (className.equals("Door"))
                {
                    Body b = new Door(level);
                    b.setPosition(PlayerLoc);
                    b.addCollisionListener(new DoorListener(game));

                }
                if (className.equals("HelperBalls"))
                { Float Gravity = Float.parseFloat(tokens[3]);
                    HelperBalls b  = new HelperBalls(level);
                    b.setPosition(PlayerLoc);
                    b.setGravityScale(Gravity);


                }

                if (className.equals("Chaser"))
                {
                    Float Gravity = Float.parseFloat(tokens[3]);
                     Chaser b = new Chaser(level);
                    b.setPosition(PlayerLoc);
                    b.setGravityScale(Gravity);
                }

                if (className.equals("Coins"))
                {
                    Float Gravity = Float.parseFloat(tokens[3]);
                    Coins b = new Coins(level);
                    b.setPosition(PlayerLoc);
                    b.setGravityScale(Gravity);
                    b.addCollisionListener(new Pickup(level.getPlayer()));



                }

                if (className.equals("Platform"))
                {
                    Float w = Float.parseFloat(tokens[3]);
                    Float h = Float.parseFloat(tokens[4]);
                    Body b = new Platform(level, w, h);
                    b.setPosition(PlayerLoc);

                }
                if (className.equals("Ramp"))
                {
                    Float q = Float.parseFloat(tokens[3]);
                    Float w = Float.parseFloat(tokens[4]);
                    Float e = Float.parseFloat(tokens[5]);

                    Float r = Float.parseFloat(tokens[6]);
                    Float t = Float.parseFloat(tokens[7]);
                    Float y = Float.parseFloat(tokens[8]);
                    Body b = new Ramp(level,q,w,e,r,t,y);
                    BodyImage image = new BodyImage("data/RAMP.png", 5);
                    b.addImage(image);
                    b.setPosition(PlayerLoc);

                }
                if (className.equals("RampNoPic"))
                {
                    Float q = Float.parseFloat(tokens[3]);
                    Float w = Float.parseFloat(tokens[4]);
                    Float e = Float.parseFloat(tokens[5]);

                    Float r = Float.parseFloat(tokens[6]);
                    Float t = Float.parseFloat(tokens[7]);
                    Float y = Float.parseFloat(tokens[8]);
                    Body b = new Ramp(level,q,w,e,r,t,y);

                    b.setPosition(PlayerLoc);

                }
                if(className.equals("BallGrid"))
                {
                    Float a = Float.parseFloat(tokens[3]);

                    Body b = new BallGrid(level, a);
                    b.setPosition(PlayerLoc);

                }
            }
return level;

        } finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }
}
