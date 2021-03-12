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
        super(x, y,ID,Ad,Tur);
        this.x = x;
        this.y=y;
        this.ID = ID;
        this.Tur = Tur;
        this.game = game;
    }

    @Override
    public void update() {
        if(game.getKeyManager().up)
            y -= 45;
        if(game.getKeyManager().down)
            y += 45;
        if(game.getKeyManager().left)
            x -= 45;
        if(game.getKeyManager().right)
            x += 45;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Arkaplan,0,0,null);
        g.drawImage(Assets.GozlukluSirin,(int)x,(int)y,null);
    }

}
