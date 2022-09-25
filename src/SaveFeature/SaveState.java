package SaveFeature;

import Characters.HelperBalls;
import Characters.Semoji;
import Door.Door;
import Elements.RampNoPic;
import city.cs.engine.*;
import Elements.BallGrid;
import game.GameLevel;
import Elements.*;
import java.io.*;

/**
 * @author      first name, last name, email
 * @version     current version number of program
 * @since       the version of the package this class was first added to
 */

public class SaveState {

    /**
     *This is where the variable is declared. String type for the file name where the data is being saved to,
     */


    private String fileName;

    public SaveState(String fileName) {
        this.fileName = fileName;
    }
    /**
     *Here begins the definition of the saving feature.
     */
    public void writeSaveState(GameLevel gameWorld) throws IOException {
        boolean append = false;
        FileWriter writer = null;

        try {
            /**
             *When the program saves the data into a text file, it will replace whatever data was already in that file with new information.
             * Hence why the boolean "append" is false, this also means that declaring it is redundant but I have chosen to keep it there.
             */
            writer = new FileWriter(fileName, append);
            writer.write(gameWorld.GetLevelNumber() + "\n");
/**
 *Here the file saver will record certain attribute of the player, for example, positions, gravity scale, etc.
 */
            writer.write(gameWorld.getPlayer().getClass().getSimpleName() + "," +
                    gameWorld.getPlayer().getPosition().x + "," +
                    gameWorld.getPlayer().getPosition().y + ","+
                    gameWorld.getPlayer().getGravityScale() + "," +
                    gameWorld.getPlayer().getCoinCount() + "," +
                    gameWorld.getPlayer().getHealthCount() +  "\n");

/**
 * Distinction is made between different types of bodies in the world so that different attributes can be saved from each one.
 * The way it works is by looking for instances of each class that I have created in this project.
 */
            for(DynamicBody body: gameWorld.getDynamicBodies()) {
                if (!(body instanceof Semoji)){
                writer.write(body.getClass().getSimpleName() + "," +
                        body.getPosition().x + "," +
                        body.getPosition().y + "," +
                        body.getGravityScale() + "\n");
            }
            }


/**
 *Here only the static body type will be saved whereas above only dynamic bodies are saved.
 */
            for(StaticBody body: gameWorld.getStaticBodies())
            {

                if(body instanceof Platform)

            {
                writer.write(body.getClass().getSimpleName() + "," +
                        body.getPosition().x + "," +
                        body.getPosition().y + "," +
                        ((Platform) body).getWidth() + "," +
                        ((Platform) body).getHeight() + "\n");
            }
                if(body instanceof Door)

                {
                    writer.write(body.getClass().getSimpleName() + "," +
                            body.getPosition().x + "," +
                            body.getPosition().y + "," +"\n");
                }

                if(body instanceof BallGrid)
                {
                    writer.write(body.getClass().getSimpleName() + "," +
                            body.getPosition().x + "," +
                            body.getPosition().y + "," +
                            ((BallGrid) body).getRadius() + "\n");

                }
             if(body instanceof Ramp)

            {
                writer.write(body.getClass().getSimpleName() + "," +
                        body.getPosition().x + "," +
                        body.getPosition().y + "," +
                        ((Ramp) body).getA() + "," +
                        ((Ramp) body).getB() + "," +
                        ((Ramp) body).getA2() + "," +
                        ((Ramp) body).getB2() + "," +
                        ((Ramp) body).getA3() + "," +
                        ((Ramp) body).getB3() + "\n");

            }

                if(body instanceof RampNoPic)

                {
                    writer.write(body.getClass().getSimpleName() + "," +
                            body.getPosition().x + "," +
                            body.getPosition().y + "," +
                            ((RampNoPic) body).getA() + "," +
                            ((RampNoPic) body).getB() + "," +
                            ((RampNoPic) body).getA2() + "," +
                            ((RampNoPic) body).getB2() + "," +
                            ((RampNoPic) body).getA3() + "," +
                            ((RampNoPic) body).getB3() + "\n");

                }

            }
        } finally {
            if (writer != null) {
                writer.close();
            }


       }
    }

}
