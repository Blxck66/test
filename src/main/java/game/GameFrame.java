package game;

import javax.swing.*;
import java.awt.*;

public class GameFrame
{
    private String title;
    private int height;
    private int width;
    private JFrame frame;
    private Canvas canvas;
    public static String ke = "";

    public GameFrame(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createFrame();
    }

    public synchronized void createFrame() {
        frame = new JFrame();
        frame.setTitle(this.title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setFocusable(false);
        canvas.setBackground(Color.BLACK);

        frame.add(canvas);
        frame.pack();
        frame.setVisible(true);

    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public JFrame getFrame() {
        return this.frame;
    }
}
