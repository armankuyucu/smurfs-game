package Game;

import java.awt.*;
import java.util.Timer;

public abstract class Obje {
    protected int olusmaSuresi;
    protected int width =60, height =60;
    public Timer timer = new Timer();
    public int satir,sutun;
    public boolean used;
    public Obje(int olusmaSuresi,int satir,int sutun,boolean used){
        this.olusmaSuresi = olusmaSuresi;
        this.satir = satir;
        this.sutun =sutun;
        this.used = used;
    }

    public abstract void update();
    public abstract void render(Graphics g);

    public int getOlusmaSuresi() {
        return olusmaSuresi;
    }

    public void setOlusmaSuresi(int olusmaSuresi) {
        this.olusmaSuresi = olusmaSuresi;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getSatir() {
        return satir;
    }

    public void setSatir(int satir) {
        this.satir = satir;
    }

    public int getSutun() {
        return sutun;
    }

    public void setSutun(int sutun) {
        this.sutun = sutun;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
