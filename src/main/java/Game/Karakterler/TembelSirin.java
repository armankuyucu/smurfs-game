package Game.Karakterler;

import Game.Game;
import Game.Assets;
import java.awt.*;

public class TembelSirin extends Oyuncu{

    public TembelSirin(Game game, float x, float y, int ID, String Ad, String Tur) {
        super(game, x, y, ID, Ad, Tur);
    }
    public void update() {
        move();
    }

    public void render(Graphics g){
        g.drawImage(Assets.Sirine,780,450,width,height,null);
        g.drawImage(Assets.TembelSirin,(int)x,(int)y,width,height,null);
    }

}
