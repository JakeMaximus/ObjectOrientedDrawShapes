import java.awt.Polygon;
import java.lang.Math;

public class Triangle extends Polygon {

    int npoints = 3;
    int width = 100;
    int height = 100;
    int[] xpoints = { 0, 50, 100 };
    int[] ypoints = { 100, 0, 100 };

    public Triangle() {
    }

    public Triangle(int[] xpoints, int[] ypoints, int npoints) {
        super(xpoints, ypoints, npoints);
    }

    public Triangle setSize(int x, int y, int width, int height) {

        for (int i = 0; i < npoints; i++) {
            xpoints[i] *= (width / (double) this.width); // ok this works way better than expected
            ypoints[i] *= (height / (double) this.height);
            xpoints[i] += x;
            ypoints[i] += y; // translate

            Math.floor(xpoints[i]);
            Math.floor(ypoints[i]);

        }

        return new Triangle(xpoints, ypoints, npoints);
    }

}