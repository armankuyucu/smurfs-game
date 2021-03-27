package Game.Karakterler;

import Game.Game;
import Game.Assets;
import java.awt.*;

import static Game.GameState.AltinListesi;

public class TembelSirin extends Oyuncu{
    int sayac = 0;
    public TembelSirin(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, sira, sutun, ID, Ad, Tur);
    }

    public void update() {
        move();
        //Altin Collision Control
        for(int i=0;i<5;i++){
            if((AltinListesi[i].sutun == Oyuncu.sira) && (AltinListesi[i].satir == Oyuncu.sutun) )
            {
                System.out.println("girdi" + sayac);
                AltinListesi[i].satir = 20;
                sayac++;
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(Assets.Sirine,780,450,width,height,null);
        g.drawImage(Assets.TembelSirin,(int)x,(int)y,width,height,null);
    }

}
