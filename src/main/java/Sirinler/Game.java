package Sirinler;

import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    //States
    private State gameState;
    private State menuState;

    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
    }

    public void init() {
        display = new Display(title, width, height);
        Assets.init();

        gameState = new GameState();
        menuState = new GameState();
        State.setState(gameState);
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
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long updates = 0;

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) /timePerUpdate;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                update();
                render();
                updates++;
                delta--;
            }
            if(timer >= 1000000000){
                System.out.println("Updates and Frames: " + updates);
                updates = 0;
                timer = 0;
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
