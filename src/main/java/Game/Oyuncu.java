package Game;

import java.awt.*;

public abstract class Oyuncu extends Karakter{

    private Game game;
    public static int satir,sutun;
    public static float x,y;

    public Oyuncu(Game game, float x, float y, int satir, int sutun, int ID, String Ad, String Tur) {
        super(Karakter.DEFAULT_CHARACTER_WIDTH,Karakter.DEFAULT_CHARACTER_HEIGHT,ID,Ad,Tur);
        this.game = game;
        Oyuncu.x = x;
        Oyuncu.y = y;
        Oyuncu.satir = satir;
        Oyuncu.sutun = sutun;
    }

    @Override
    public void update() {
        System.out.println("girdi");

    }

    @Override
    public void render(Graphics g) {

    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

}
