package Game;

import java.awt.image.BufferStrategy;
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
    private MouseManager mouseManager;

    //States
    public State gameState;
    public State menuState;
    public State winningState;
    public State losingState;

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public Game(String title, int width, int height) {
        this.height = height;
        this.width = width;
        this.title = title;
        mouseManager = new MouseManager();
        Puan.Skor = 20;
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
        if(Oyuncu.sutun == 12 && Oyuncu.satir == 7){
            winningState = new WinningState(this);
            State.setState(winningState);
        }
        if(Puan.Skor <= 0){
            losingState = new LosingState(this);
            State.setState(losingState);
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
