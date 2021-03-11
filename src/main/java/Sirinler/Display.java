package Sirinler;

import java.awt.*;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

        this.addKeyListener(new KeyListener() {

            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                switch (key) {
                    case KeyEvent.VK_UP:
                        System.out.println("UP");
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        System.out.println("DOWN");
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        System.out.println("LEFT");
                        repaint();
                        break;
                    case KeyEvent.VK_RIGHT:
                        System.out.println("RIGHT");
                        repaint();
                        break;
                }
            }

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
            }

        });
        createDisplay();
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width,height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width,height));
        canvas.setMaximumSize(new Dimension(width,height));
        canvas.setMinimumSize(new Dimension(width,height));

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

}
