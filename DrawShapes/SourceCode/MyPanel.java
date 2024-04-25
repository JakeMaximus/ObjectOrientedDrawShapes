import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Math;

public class MyPanel extends JPanel implements MouseMotionListener, MouseListener {
    Point p1 = new Point();
    Point p2 = new Point();
    Point[] clicks = new Point[2];
    int clickCount = 0;
    Image img;
    Graphics2D g2d;
    Color penColor = Color.BLACK;
    int penSize = 4;
    int mode = 0;

    Pentagon pentagon = new Pentagon();
    Triangle triangle = new Triangle();
    Square square = new Square();

    MyPanel() {
        // g2d.setStroke(new BasicStroke(penSize));
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
    }

    public void setPenColor(Color color) {
        penColor = color;
        // System.out.println(penColor);
    }

    public void setPenSize(int size) {
        penSize = size;
    }

    public void mouseMoved(MouseEvent e) {
        p1 = e.getPoint();
    }

    public void mouseDragged(MouseEvent e) {

        g2d.setStroke(new BasicStroke(penSize));
        g2d.setColor(penColor);
        p2 = e.getPoint();

        if (g2d != null) {
            g2d.drawLine(p1.x, p1.y, p2.x, p2.y);
        }

        repaint();
        p1 = p2;
    }

    public void drawTriangle(Point[] clicks) {

        g2d.setStroke(new BasicStroke(penSize));
        g2d.setColor(penColor);

        int x = Math.min(clicks[0].x, clicks[1].x);
        int y = Math.min(clicks[0].y, clicks[1].y);
        int width = Math.abs(clicks[0].x - clicks[1].x);
        int height = Math.abs(clicks[0].y - clicks[1].y);
        // System.out.println(x + "," + y + "," + width + "," + height);
        if (g2d != null) {
            triangle = triangle.setSize(x, y, width, height);
            g2d.drawPolygon((Polygon) triangle);
            // g2d.drawRect(x, y, width, height); // debug draw bounds
        }

        repaint();
    }

    public void drawPentagon(Point[] clicks) {

        g2d.setStroke(new BasicStroke(penSize));
        g2d.setColor(penColor);

        int x = Math.min(clicks[0].x, clicks[1].x);
        int y = Math.min(clicks[0].y, clicks[1].y);
        int width = Math.abs(clicks[0].x - clicks[1].x);
        int height = Math.abs(clicks[0].y - clicks[1].y);
        // System.out.println(x + "," + y + "," + width + "," + height);
        if (g2d != null) {
            pentagon = pentagon.setSize(x, y, width, height);
            g2d.drawPolygon((Polygon) pentagon);
            // g2d.drawRect(x, y, width, height); // debug draw bounds
        }

        repaint();
    }

    public void drawSquare(Point[] clicks) {

        g2d.setStroke(new BasicStroke(penSize));
        g2d.setColor(penColor);

        int x = Math.min(clicks[0].x, clicks[1].x);
        int y = Math.min(clicks[0].y, clicks[1].y);
        int width = Math.abs(clicks[0].x - clicks[1].x);
        int height = Math.abs(clicks[0].y - clicks[1].y);
        // System.out.println(x + "," + y + "," + width + "," + height);
        if (g2d != null) {
            square = square.setSize(x, y, width, height); // duh this returns new Pentagon // debug
            g2d.drawPolygon((Polygon) square);
            // g2d.drawPolygon((Polygon) s);
            // g2d.drawRect(x, y, width, height); // debug draw bounds
        }

        repaint();
    }

    protected void paintComponent(Graphics g) {
        if (img == null) {
            img = createImage(getSize().width, getSize().height);
            g2d = (Graphics2D) img.getGraphics();
            g2d.setStroke(new BasicStroke(penSize));
        } else {
            g.drawImage(img, 0, 0, null);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

        // System.out.println(clickCount);
        if (mode == 1) {
            if (clickCount >= 1) {
                clicks[clickCount] = e.getPoint();
                drawTriangle(clicks);
                clickCount = 0;
                mode = 0;
            } else {
                clicks[clickCount] = e.getPoint();
            }
            clickCount++;
        }

        if (mode == 2) {
            if (clickCount >= 1) {
                clicks[clickCount] = e.getPoint();
                drawPentagon(clicks);
                clickCount = 0;
                mode = 0;
            } else {
                clicks[clickCount] = e.getPoint();
            }
            clickCount++;
        }

        if (mode == 3) {
            if (clickCount >= 1) {
                clicks[clickCount] = e.getPoint();
                drawSquare(clicks);
                clickCount = 0;
                mode = 0;
            } else {
                clicks[clickCount] = e.getPoint();
            }
            clickCount++;
        }

        if (mode == 4) {
            if (clickCount >= 1) {
                clicks[clickCount] = e.getPoint();
                g2d.setStroke(new BasicStroke(penSize));
                g2d.setColor(penColor);
                int x = Math.min(clicks[0].x, clicks[1].x);
                int y = Math.min(clicks[0].y, clicks[1].y);
                int width = Math.abs(clicks[0].x - clicks[1].x);
                int height = Math.abs(clicks[0].y - clicks[1].y);
                g2d.drawOval(x, y, width, height); // Math.abs(clicks[0].x - clicks[1].x),
                // Math.abs(clicks[0].y - clicks[1].y));

                repaint();
                clickCount = 0;
                mode = 0;
            } else {
                clicks[clickCount] = e.getPoint();
            }
            clickCount++;
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
