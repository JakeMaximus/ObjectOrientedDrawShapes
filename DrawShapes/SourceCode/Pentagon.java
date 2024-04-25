import java.awt.Polygon;
import java.lang.Math;

public class Pentagon extends Polygon {

    int npoints = 5;
    int width = 100;
    int height = 100;
    int[] xpoints = { 50, 100, 75, 25, 0 };
    int[] ypoints = { 0, 45, 100, 100, 45 };

    public Pentagon() {
    }

    public Pentagon(int[] xpoints, int[] ypoints, int npoints) {
        super(xpoints, ypoints, npoints);
    }

    public Pentagon setSize(int x, int y, int width, int height) {

        for (int i = 0; i < npoints; i++) {
            xpoints[i] *= (width / (double) this.width); // ok this works way better than expected
            ypoints[i] *= (height / (double) this.height);
            xpoints[i] += x;
            ypoints[i] += y; // translate

            Math.floor(xpoints[i]);
            Math.floor(ypoints[i]);

        }

        return new Pentagon(xpoints, ypoints, npoints);
    }

}
