package Karakterler;

import java.awt.*;

public abstract class Karakter {
    //Bu siniftan kalitim alan sınıflarında kullanmasi icin protected
    protected int ID;
    protected String Ad;
    protected String Tur;
    protected float x,y;

    public Karakter(float x, float y, int ID, String Ad, String Tur){
        this.x = x;
        this.y = y;
        this.ID = ID;
        this.Ad = Ad;
        this.Tur = Tur;
    }

    public abstract void update();
    public abstract void render(Graphics g);

    public void EnKisaYol(){

    }

}


