package Characters;

import city.cs.engine.*;
//ENEMY WALKER EXTENDS WALKER SO THAT IT CAN BE ALLOWED TO WALK ON ITS OWN
public class Enemy extends Walker {

    //BASE SHAPE FOR ENEMY CLASS IS A CIRCLE AS IT IS BETTER SUITED FOR GAMEPLAY ENJOYABILITY
    private static final Shape shape = new PolygonShape(-0.466f,0.352f, 0.02f,-0.34f, 0.49f,0.38f);
    //IMAGE ATTRIBUTED TO ENEMY DOES NOT EXACTLY MATCH GIVEN SHAPE FOR THE AFOREMENTIONED REASON
    private static final BodyImage image =
            new BodyImage("data/GOODMRBEANE.gif", 3);

//ENEMY STARTS IN GAMEWORLD
    public Enemy(World world) {
        super(world, shape);
        //IMAGE ADDED TO ENEMY
        addImage(image);
    }


}
