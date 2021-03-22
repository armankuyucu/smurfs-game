package Game.Karakterler;

import java.awt.*;

public abstract class Karakter {
    //Bu siniftan kalitim alan sınıflarında kullanmasi icin protected
    public static final float DEFAULT_SPEED = 90.0f;
    public static final int DEFAULT_CHARACTER_WIDTH = 40,
                            DEFAULT_CHARACTER_HEIGHT = 60;

    protected int ID;
    protected String Ad;
    protected String Tur;
    public static float x,y;
    protected int width, height;
    protected float speed;
    protected float xMove, yMove;

    public Karakter(float x, float y, int width, int height, int ID, String Ad, String Tur){
        Karakter.x = x;
        Karakter.y = y;
        this.ID = ID;
        this.Ad = Ad;
        this.Tur = Tur;
        this.width = width;
        this.height = height;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public abstract void update();
    public abstract void render(Graphics g);

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

    //Getters and Setters
    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }


}


