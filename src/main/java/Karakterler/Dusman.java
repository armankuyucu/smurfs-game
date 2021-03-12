package Karakterler;

import java.awt.*;

public abstract class Dusman extends Karakter{
    protected int ID;
    protected String Ad;
    protected String Tur;
    protected float x,y;

    public Dusman(float x, float y, int ID, String Ad, String Tur) {
        super(x, y, ID, Ad, Tur);
    }

}
