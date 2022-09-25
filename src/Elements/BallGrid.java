package Elements;

import city.cs.engine.*;


public class BallGrid extends StaticBody {
        private float Radius;
    public BallGrid(World w, float Radius){
            super (w);
            Shape s = new CircleShape(Radius);
            Fixture f = new SolidFixture(this, s);
            this.Radius = Radius;
        }
        public float getRadius(){

            return Radius;
        }

    }
