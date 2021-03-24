package Game.Karakterler;

import Game.Game;
import Game.GameState;
import Game.Assets;

import java.awt.*;

public class Gargamel extends Dusman{


    public Gargamel(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, sira, sutun, ID, Ad, Tur);
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.Gargamel,(int)x,(int) y,width,height,null);
    }
}
