package Karakterler;

import Game.Assets;
import Game.Game;

import java.awt.*;

public class GozlukluSirin extends Oyuncu{

    public GozlukluSirin(Game game, float x, float y, int ID, String Ad, String Tur) {
        super(game, x, y, ID, Ad, Tur);
    }
    public void update() {
        getInput();
        move();
    }

    public void render(Graphics g){
        g.drawImage(Assets.Sirine,1100,630,width,height,null);
        g.drawImage(Assets.GozlukluSirin,(int)x,(int)y,width,height,null);
    }
}
