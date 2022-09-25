package Elements;

import city.cs.engine.*;

public class Platform extends StaticBody {
    private float width;
    private float height;
    public Platform(World w, float width, float height){
        super (w);
        Shape s = new BoxShape(width, height);
        Fixture f = new SolidFixture(this, s);
        this.width = width;
        this.height = height;
    }
    public float getWidth(){
        return width;
    }
    public float getHeight() {
        return height;
    }
}
