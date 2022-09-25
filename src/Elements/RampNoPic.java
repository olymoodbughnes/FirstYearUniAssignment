package Elements;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class RampNoPic extends StaticBody{
    private float a;
    private float b;
    private float a2;
    private float b2;
    private float a3;
    private float b3;

    public RampNoPic(World w, float a, float b,  float a2, float b2,  float a3, float b3){
        super (w);
        Shape s = new PolygonShape(a, b, a2, b2, a3, b3);
        Fixture f = new SolidFixture(this, s);
        this.a = a;
        this.b = b;
        this.a2 = a2;
        this.b2 = b2;
        this.a3 = a3;
        this.b3 = b3;
    }
    public float getA() {
        return a;
    }
    public float getB() {
        return b;
    }
    public float getA2() {
        return a2;
    }
    public float getB2() {
        return b2;
    }
    public float getA3() {
        return a3;
    }
    public float getB3() {
        return b3;
    }
}
