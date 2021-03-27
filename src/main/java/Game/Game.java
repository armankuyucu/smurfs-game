package Game;

import Game.Karakterler.Oyuncu;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Game.GameState.AltinListesi;

/**
 *
 * @author arman
 */
public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;
    private boolean running = false;
    private Thread thread;
    private BufferStrategy bs;
    private java.awt.Graphics g;
    private MouseManager mouseManager;

    //States
    public State gameState;
    public State menuState;

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
        mouseManager = new MouseManager();
    }

    public void init() {
        display = new Display(title, width, height);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();
        menuState = new MenuState(this); //Passes an instance of this class
        State.setState(menuState);
    }

    private void update() {

        if(State.getState() != null){
            State.getState().update();
        }

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        if(State.getState() != null){
            State.getState().render(g);
        }

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        int fps = 60;
        double timePerUpdate = 1000000000.d / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        //Game Loop
        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) /timePerUpdate;
            lastTime = now;

            if(delta >= 1){
                update();
                render();
                delta--;
            }
        }

        stop();
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
