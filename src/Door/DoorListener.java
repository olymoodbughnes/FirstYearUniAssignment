package Door;

import city.cs.engine.*;
import game.Game;
import Characters.Semoji;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 */
public class DoorListener implements CollisionListener {
    private Game game;
    public DoorListener(Game game) {
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        Semoji player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.goNextLevel();

        }
    }
}
