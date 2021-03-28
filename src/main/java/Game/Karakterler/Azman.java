package Game.Karakterler;

import Game.Game;
import Game.Assets;
import Game.Tiles.Tile;

import java.awt.*;

public class Azman extends Dusman{


    public Azman(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, sira, sutun, ID, Ad, Tur);
        EnKisaYol();
    }

    public void EnKisaYol(){
        this.dijkstra(AdjacencyMatrix,(sira*13+sutun),(Oyuncu.sutun+Oyuncu.sira*13));
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println("Sonuc: " + path.get(2) % 13);
    }

    public void PrintDestination(Graphics g){

    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics g) {

        for(int i=0;i<path.size();i++){
            g.drawImage(Assets.GreenTile,(path.get(i) % 13)* Tile.TILEWIDTH,(path.get(i) / 13)*Tile.TILEWIDTH,null);
        }

        g.drawImage(Assets.Azman,(int)x,(int) y,width,height,null);

    }

}
