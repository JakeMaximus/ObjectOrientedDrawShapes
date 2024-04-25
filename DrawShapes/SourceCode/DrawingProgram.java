import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class DrawingProgram extends JFrame implements ActionListener, ChangeListener {

    // private Point p1 = new Point();
    private Color brushColor = Color.BLACK;
    private JPanel panel = new MyPanel();
    private int brushSize;
    private JSlider brushSlider = new PenSizeSlider();

    public DrawingProgram() {
        super("Painter");
        JPanel toolbar = new JPanel(new FlowLayout(FlowLayout.LEFT));
        toolbar.add(new Label("Drag mouse to draw"));

        JButton colorBtn = new JButton("Select Color");
        colorBtn.setName("colorBtn");
        colorBtn.addActionListener(this);

        JButton sizeBtn = new JButton("Select Brush Size");
        sizeBtn.setName("sizeBtn");
        sizeBtn.addActionListener(this);

        JButton triangle = new JButton("Triangle");
        triangle.setName("Triangle");
        triangle.addActionListener(this);

        JButton pentagon = new JButton("Pentagon");
        pentagon.setName("pentagon");
        pentagon.addActionListener(this);

        JButton square = new JButton("Square");
        square.setName("square");
        square.addActionListener(this);

        JButton oval = new JButton("Oval");
        oval.setName("Oval");
        oval.addActionListener(this);

        brushSlider.addChangeListener(this);

        toolbar.add(colorBtn);
        toolbar.add(brushSlider);
        toolbar.add(triangle);
        toolbar.add(pentagon);
        toolbar.add(square);
        toolbar.add(oval);

        this.add(toolbar, BorderLayout.SOUTH);
        setSize(800, 600);

        // panel.addMouseMotionListener(this);
        this.add(panel, BorderLayout.CENTER);

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        brushSize = ((PenSizeSlider) brushSlider).getBrushSize();
        ((MyPanel) panel).setPenSize(brushSize);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnName = "temp";

        if (e.getSource() instanceof JButton) {
            JButton tempBtn = (JButton) e.getSource();
            btnName = tempBtn.getName();

            if (btnName.equals("colorBtn")) {
                Color newColor = JColorChooser.showDialog(null, "Color Chooser", this.getBackground());
                brushColor = newColor;
                ((MyPanel) panel).setPenColor(brushColor);
            }

            else if (btnName.equals("Triangle")) {
                ((MyPanel) panel).mode = 1;
            }

            else if (btnName.equals("pentagon")) {
                ((MyPanel) panel).mode = 2;
            }

            else if (btnName.equals("square")) {
                ((MyPanel) panel).mode = 3;

            } else if (btnName.equals("Oval")) {
                ((MyPanel) panel).mode = 4;
            }

            ((MyPanel) panel).clickCount = 0;

        }
    }

    public static void main(String[] args) {
        new DrawingProgram();
    }
}