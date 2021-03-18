package Karakterler;

import Game.Assets;
import Game.Game;

import java.awt.*;

public class Oyuncu extends Karakter{
    protected int ID;
    protected String Ad;
    protected String Tur;
    protected float x,y;
    private Game game;

    public Oyuncu(Game game, float x, float y, int ID, String Ad, String Tur) {
        super(x, y,Karakter.DEFAULT_CHARACTER_WIDTH,Karakter.DEFAULT_CHARACTER_HEIGHT,ID,Ad,Tur);
        this.x = x;
        this.y=y;
        this.ID = ID;
        this.Tur = Tur;
        this.game = game;
    }

    public void move(){
        x += xMove;
        y += yMove;
    }

    public void getInput(){
        xMove = 0;
        yMove = 0;

        if(game.getKeyManager().up)
            yMove = -speed;
        if(game.getKeyManager().down)
            yMove = speed;
        if(game.getKeyManager().left)
            xMove = -speed;
        if(game.getKeyManager().right)
            xMove = speed;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

    }
}
