package Collectibles;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Color;
import java.io.IOException;

//COLLECTIBLE CLASS CREATED AND EXTENDS DYNAMYC BODY
public class Coins extends DynamicBody {
    private static final Shape shape = new CircleShape(0.2f);
    //IMAGE ATTRIBUTED TO COLLECTIBLE
    private static final BodyImage image =
            new BodyImage("data/COLLECTIBLE2.gif", 1);
    //COLLECTIBLE SET IN GAMEWORLD SO THAT IT APPEARS ONCE IT IS STARTED
    public Coins(World world) {
        super(world, shape);
        addImage(image);


    }
}
