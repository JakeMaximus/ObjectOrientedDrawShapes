import javax.swing.JSlider;
import javax.swing.event.*;

public class PenSizeSlider extends JSlider implements ChangeListener {

    private int brushSize = 4;

    public PenSizeSlider() {
        super(1, 10);
        setMajorTickSpacing(1);
        setMinorTickSpacing(1);
        setPaintTicks(true);
        setPaintLabels(true);
        addChangeListener(this);
    }

    public int getBrushSize() {
        return brushSize;
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        brushSize = slider.getValue();
    }
}