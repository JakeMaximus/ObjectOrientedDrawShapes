import java.awt.Polygon;
import java.awt.Rectangle;
import java.lang.Math;

public class Square extends Polygon {
    Rectangle bounds;
    int npoints = 4;
    int width = 100;
    int height = 100;
    int[] xpoints = { 0, 100, 100, 0 };
    int[] ypoints = { 0, 0, 100, 100 };

    public Square() {
    }

    public Square(int[] xpoints, int[] ypoints, int npoints) {
        super(xpoints, ypoints, npoints);
    }

    public Square setSize(int x, int y, int width, int height) {

        for (int i = 0; i < npoints; i++) {
            xpoints[i] *= (width / (double) this.width); // ok this works way better than expected
            ypoints[i] *= (height / (double) this.height);
            xpoints[i] += x;
            ypoints[i] += y; // translate

            Math.floor(xpoints[i]);
            Math.floor(ypoints[i]);

        }

        return new Square(xpoints, ypoints, npoints);
    }

}
