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

    private BufferedImage Arkaplan;
    private BufferedImage GozlukluSirin;

    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
    }

    public void init() {
        display = new Display(title, width, height);
        Arkaplan = ImageLoader.loadImage("/Arkaplan.png");
        GozlukluSirin = ImageLoader.loadImage("/GozlukluSirin.png");

    }

    private void update() {

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(2);
            return;
        }
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, width, height);

        g.drawImage(Arkaplan, 0,0, null);
        g.drawImage(GozlukluSirin, 560,450, null);

        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();

        while (running) {
            update();
            render();
            try {
                TimeUnit.MILLISECONDS.sleep(20); // Cpu kullanımını azaltmak için
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
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
