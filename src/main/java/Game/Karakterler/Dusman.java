package Game.Karakterler;

import Game.Game;

public abstract class Dusman extends Karakter{
    protected int ID;
    protected String Ad;
    protected String Tur;
    protected float x,y;
    private Game game;
    private int sira,sutun;

    public Dusman(Game game,float x, float y,int sira,int sutun, int ID, String Ad, String Tur) {
        super(Karakter.DEFAULT_CHARACTER_WIDTH,Karakter.DEFAULT_CHARACTER_HEIGHT,ID, Ad, Tur);
        this.game = game;
        this.x = x;
        this.y = y;
        this.sira = sira;
        this.sutun = sutun;
    }

    public void update(){

    }

    public void render(){

    }
}
