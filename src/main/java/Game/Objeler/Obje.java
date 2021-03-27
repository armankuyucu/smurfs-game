package Game.Objeler;

import java.awt.*;

public abstract class Obje {
    protected int deger;
    protected int olusmaSuresi;
    protected int width =64, height =64;
    public int satir,sutun;
    public Obje(int deger,int olusmaSuresi,int satir,int sutun){
        this.deger = deger;
        this.olusmaSuresi = olusmaSuresi;
        this.satir = satir;
        this.sutun =sutun;
    }

    public abstract void update();
    public abstract void render(Graphics g);
}
