package Characters;
import city.cs.engine.*;


public class Chaser extends Walker {


    private static final Shape shape = new CircleShape(0.05f);

    private static final BodyImage image =
            new BodyImage("data/annoyingemoji.gif", 2);

    public Chaser(World world){
        super(world, shape);

        addImage(image);


    }

}
