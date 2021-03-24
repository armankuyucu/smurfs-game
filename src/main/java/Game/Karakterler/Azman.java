package Game.Karakterler;

import Game.Game;
import Game.Assets;

import java.awt.*;

public class Azman extends Dusman{


    public Azman(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, sira, sutun, ID, Ad, Tur);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Azman,(int)x,(int) y,width,height,null);
    }
}
