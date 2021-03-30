package Game;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author arman
 */
public class Display extends JFrame {

    private JFrame frame;
    private String title;
    public int width, height;
    private Canvas canvas;

    public Display(String title,int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(new KeyboardManager());

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Frame getFrame(){ return frame;}

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
