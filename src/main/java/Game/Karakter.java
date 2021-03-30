package Game;

import java.awt.*;

public abstract class Karakter {

    //Bu siniftan kalitim alan sınıflarin da kullanmasi icin protected
    public static final int DEFAULT_CHARACTER_WIDTH = 40,
                            DEFAULT_CHARACTER_HEIGHT = 60;

    protected int ID;
    protected String Ad;
    protected String Tur;
    protected int width, height;

    public Karakter(int width, int height, int ID, String Ad, String Tur){
        this.ID = ID;
        this.Ad = Ad;
        this.Tur = Tur;
        this.width = width;
        this.height = height;
    }

    public Karakter(){

    }

    public abstract void update();
    public abstract void render(Graphics g);

    //Getters and Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String ad) {
        Ad = ad;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String tur) {
        Tur = tur;
    }

    public void EnKisaYol(){

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

}


