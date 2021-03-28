package Game.Karakterler;

import Game.Game;
import Game.Assets;
import Game.Tiles.Tile;

import java.awt.*;

public class Azman extends Dusman{

    public static int azmanSira,azmanSutun;
    public boolean ilkKez = true;

    public Azman(Game game, float x, float y, int sira, int sutun, int ID, String Ad, String Tur) {
        super(game, x, y, ID, Ad, Tur);
        System.out.println("sira: " + sira);
        azmanSutun = sutun;
        azmanSira = sira;
        EnKisaYol();
        System.out.println("Azmansira: " + azmanSira);

    }

    public Azman(){

    }

    @Override
    public void EnKisaYol(){
        pressed = false;
        path.clear();
        this.dijkstra(AdjacencyMatrix,(azmanSira*13+azmanSutun),(Oyuncu.sutun+Oyuncu.sira*13));

        //path.remove(0);
        ilkKez = true;
        if(!ilkKez){
            if(path.get(1) - path.get(0) == 1){
                azmanSutun++;
                System.out.println("Sutun++");
            }
            else if(path.get(1) - path.get(0) == -1){
                azmanSutun--;
                System.out.println("Sutun--");
            }
            else if(path.get(1) - path.get(0) == 13){
                azmanSira++;
                System.out.println("Sira++");
            }
            else if(path.get(1) - path.get(0) == -13){
                azmanSira--;
                System.out.println("Sira--");
            }
        }
        for(int i=0;i<path.size();i++){
            System.out.print(path.get(i) + " ");
        }
        ilkKez = false;
        System.out.println();
    }


    @Override
    public void update() {
        if(pressed){
            EnKisaYol();
        }
    }

    @Override
    public void render(Graphics g) {
        /*if(pressed){
            for(int i=0;i<path.size();i++){
                g.drawImage(Assets.WhiteTile,(path.get(i) % 13)* Tile.TILEWIDTH,(path.get(i) / 13)*Tile.TILEWIDTH,null);
            }
        }

        for(int i=0;i<path.size();i++){
            g.drawImage(Assets.GreenTile,(path.get(i) % 13)* Tile.TILEWIDTH,(path.get(i) / 13)*Tile.TILEWIDTH,null);
        }*/

        g.drawImage(Assets.Azman,(azmanSutun)* Tile.TILEWIDTH,(azmanSira)*Tile.TILEWIDTH,width,height,null);

    }

}
