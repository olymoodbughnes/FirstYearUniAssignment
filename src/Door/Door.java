package Door;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level. 
 */
public class Door extends StaticBody {   
    
    /**
     * Initialise a new door.
     * @param world The world.
     */
    public Door(World world) {
        super(world, new BoxShape(0.55f, 1.4f));
        addImage(new BodyImage("data/door.png", 2.8f));

    }
}
