package display;

import javax.swing.*;
import java.awt.*;

public class Display {
    private JFrame frame;
    private String title;
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private Dimension dimension = new Dimension(WIDTH, HEIGHT); // resolution
    private Canvas canvas;
    public Display(String title) {
        initialize(title);
    }

    private void initialize(String title) {
        this.frame = new JFrame(title);
        this.frame.setVisible(true);
        this.frame.setMinimumSize(dimension);
        this.frame.setPreferredSize(dimension);
        this.frame.setMaximumSize(dimension);
        this.frame.setFocusable(true);
        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.canvas = new Canvas();

        this.canvas.setMinimumSize(dimension);
        this.canvas.setPreferredSize(dimension);
        this.canvas.setMaximumSize(dimension);
        this.canvas.setVisible(true);

        this.frame.add(canvas);
        this.frame.pack();
    }
}
