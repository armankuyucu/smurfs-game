package Game.Karakterler;

import Game.Game;

import java.awt.*;

public abstract class Oyuncu extends Karakter{

    private Game game;
    public static int sira,sutun;
    public static float x,y;

    public Oyuncu(Game game, float x, float y, int sira,int sutun,int ID, String Ad, String Tur) {
        super(Karakter.DEFAULT_CHARACTER_WIDTH,Karakter.DEFAULT_CHARACTER_HEIGHT,ID,Ad,Tur);
        this.game = game;
        Oyuncu.x = x;
        Oyuncu.y = y;
        Oyuncu.sira = sira;
        Oyuncu.sutun = sutun;
    }

    @Override
    public void update() {
        System.out.println("girdi");

    }

    @Override
    public void render(Graphics g) {

    }
}
