package Game.Karakterler;

import Game.Assets;
import Game.Game;
import Game.Objeler.Altin;
import Game.Objeler.Mantar;

import java.awt.*;

public class GozlukluSirin extends Oyuncu{

    public GozlukluSirin(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, sira, sutun, ID, Ad, Tur);
    }

    public void update() {
        move();
        Altin.AltinCollisionDetection();
        Mantar.MantarCollisionDetection();
    }

    public void render(Graphics g){
        g.drawImage(Assets.Sirine,780,450,width,height,null);
        g.drawImage(Assets.GozlukluSirin,(int)x,(int)y,width,height,null);
    }
}
