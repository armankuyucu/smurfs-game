package Game.Objeler;

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
}
