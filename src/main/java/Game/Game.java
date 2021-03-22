package Game;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.*;
import java.util.Scanner;
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
        gameState = new GameState(this); //Passes an instance of this class
        menuState = new GameState(this);
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
/*
        //Haritayi Cizme
        for(int y=0;y<11;y++){
            for(int x=0;x<13;x++){
                if(matrix[y][x] == 1){
                    //Kapilar
                    if(y==5 && x==0 || x==3 && y==0 || x==3 && y==10 || x==10 && y==0){
                        g.setColor(Color.PINK);
                    }
                    //Baslangic Noktasi
                    else if(y==5 && x==6){
                        g.setColor(Color.BLUE);
                    }
                    //Bosluklar
                    else{
                        g.setColor(Color.WHITE);
                    }
                    g.fillRect(x*64,y*64,64,64);
                }
                else if(matrix[y][x] == 0){
                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x*64,y*64,64,64);
                }
                g.setColor(Color.BLACK);
                g.drawLine(0,y*64,832,y*64); // x ekseni
                g.drawLine(x*64,0,x*64,704);  // y ekseni
            }
        }
*/
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
        long timer = 0;
        long updates = 0;

        //Game Loop
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
