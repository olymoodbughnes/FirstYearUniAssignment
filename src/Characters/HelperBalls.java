package Characters;

import city.cs.engine.*;

public class HelperBalls extends Walker {
public static final Shape shape = new CircleShape(0.25f);
    public HelperBalls(World world){

        super(world, shape);

    }
}
